package com.npci.contoller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.beans.Employee;
import com.npci.collection_exception.EmployeeNotFoundException;
import com.npci.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
   // controller depends on the service layer hence autowired the EmployeeService
	@Autowired
	private EmployeeService service;
	
	//a string of exceptions
	private List<String> exceptionList =new ArrayList<>();
	
	@GetMapping(path="/employees")
	public ResponseEntity<Object> getAllEmployees()
	{
		List<Employee> employees=service.findEmployees();
		// adding employees into response body 
		// springboot automatically convert to json format
		return ResponseEntity.status(200).body(employees);
	}
	
	// web service  to get the employee based on the id
	//  /api/employees/id
	@GetMapping(path="/employees/{id}") 
	public ResponseEntity<Object> getEmployeeById(@PathVariable("id") int id)
	{
		try {
			Employee employees=service.findEmployee(id);
			return ResponseEntity.status(200).body(employees);
			
		}catch(EmployeeNotFoundException e) {
			exceptionList.add(e.getMessage());
			Map<String,String>errors=new HashMap<>();
			errors.put("error", e.getMessage());
			return ResponseEntity.status(400).body(errors);
		}
	}
	
	// create a webservice to store the employee object pass only (name="ABC",salary="4355")
	@PostMapping(path="/employees" , consumes=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> setEmployee(@RequestBody Employee e)
	{
		// json properties automatically maped to employee properties when the names are same
		
		Employee created= service.createEmployee(e);
		return ResponseEntity.status(201).body(created);
	}
	
	@GetMapping(path="employees/searchByName/{name}")
	public ResponseEntity<Object> getEmployees(@PathVariable("name") String name)
	{
		List<Employee> employees=service.findEmployeesByName(name);
		return ResponseEntity.status(200).body(employees);
	}
	
}
