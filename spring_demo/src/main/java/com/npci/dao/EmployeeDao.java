package com.npci.dao;

import java.util.List;

import com.npci.beans.Employee;

public interface EmployeeDao {
 
	public Employee save(Employee employee);
	 public Employee findById(int id);
	 public List<Employee> findAll();
	 public void delete(int id);
 
}
