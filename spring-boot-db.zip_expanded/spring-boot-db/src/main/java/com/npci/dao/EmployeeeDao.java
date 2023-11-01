package com.npci.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.beans.Employee;

public interface EmployeeeDao extends JpaRepository<Employee, Integer> {
//    it inherits following methods
//     T save(T t) >>Employee save (Employee t)
//	 Optional <T> findById(ID id) >> Optional <Employee> findById(Integer id)
//	 List<T> findAll() >> List<Employee> findAll()
//    void deleteById(Id id) >> void deleteById(Integer id)
	
	// creating custom queries
	// Jpa auto implements the method for us
	@Query("select e from Employee e where e.name=?1")
	public List<Employee>findByName(String name);
	
}
