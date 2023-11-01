package com.npci.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npci.beans.Employee;
import com.npci.collection_exception.EmployeeNotFoundException;
import com.npci.dao.EmployeeDao;

@Service("service")  // id=service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
	private EmployeeDao dao;

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public List<Integer> createEmployees(Employee employee1, Employee... employees) {
	    List<Integer> idList=new ArrayList<>();
		dao.save(employee1);
		idList.add(employee1.getId());
	   for(Employee e:employees)
	   {
		   dao.save(e);
			idList.add(e.getId());
	   }
		return idList;
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		
		return dao.save(employee);
	}

	@Override
	public Employee findEmployee(int id) throws EmployeeNotFoundException {
		Employee employee=dao.findById(id);
		if(employee==null)
		{
			throw new EmployeeNotFoundException("Employee not Found...");
		}
		return employee;
	}

	
	@Override
	public List<Employee> findEmployeesByName(String name) {
		List<Employee> employees=dao.findAll();
		List<Employee> names= employees.stream()
		.filter(item->item.getName().equals(name))
		.collect(Collectors.toList());
		return names;
	}

	@Override
	public List<Employee> findEmployees() {
		
		return dao.findAll();
	}
	
	@Override
	@Transactional
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		
		Employee employee=dao.findById(id);
		if(employee==null)
		{
			throw new EmployeeNotFoundException("Employee not Found...");
		}
		else
		   dao.delete(id);
		
	}


}
