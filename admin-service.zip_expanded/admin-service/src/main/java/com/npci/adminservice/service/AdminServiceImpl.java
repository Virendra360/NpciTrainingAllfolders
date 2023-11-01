package com.npci.adminservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("service")
public class AdminServiceImpl {

	@Autowired
	private RestTemplate rest;
	// for now convert json to string 
	public String findingEmployee(int id)
	{
		String response =
				rest.getForObject("http://EMPLOYEE-APP/api/employees/"+id, String.class);
		// here we will get the response content, which can be change to types
		// like Employee.class, Customer.classand so on
		// as rest.getForObject(url,Employee.class) - converts employee to json object
		return response;
	}
	
}
