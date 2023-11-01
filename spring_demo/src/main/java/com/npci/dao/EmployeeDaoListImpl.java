package com.npci.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.npci.beans.Employee;

public class EmployeeDaoListImpl implements EmployeeDao {
	private List<Employee> inMemory;
	
	public EmployeeDaoListImpl() {
		inMemory=new ArrayList<>();
	}

	@Override
	public Employee save(Employee employee) {
		// at time of passing id  will be 0
		employee.setId(inMemory.size()+1); // set based on the size
		inMemory.add(employee);
		return employee; // at time of returning their will be id 
	}

	@Override
	public Employee findById(int id) {
		
		// once try stream filter method to search, its better approach to do
		for(Employee e:inMemory)
		{
			if(e.getId()==id)
				return e;
		}
		return null;
	}

	@Override
	public List<Employee> findAll() {
		return inMemory;
	}

	@Override
	public void delete(int id) {
		Iterator<Employee> itr=inMemory.iterator();
		while(itr.hasNext()) {
			Employee emp=itr.next();
			if(emp.getId()==id)
			{
				itr.remove();
				break;
			}
		}
	}
}
