package com.npci.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.npci.beans.Employee;

public class EmployeeDaoTestCase {

private static ApplicationContext context;
    private EmployeeDao employeeDao;
    
    // load ApplicationContext before any test case begins
    // executed only once before any test case begins
    @BeforeAll
    public static void load()
    {
    	context=new ClassPathXmlApplicationContext("beans.xml");
    }
 // executed only once but after all test case ends
    @AfterAll
    public static void unload()
    {
    	ClassPathXmlApplicationContext context2=(ClassPathXmlApplicationContext)context;
    	context2.close();
    }
    
    //runs before each test case
    // test driven approach-to test your methods
    // 
    @BeforeEach
    public void initializeGreetings()
    {
    	 employeeDao =(EmployeeDao)context.getBean("b2");
    }
    
    
    
    //runs after each case
    @AfterEach
    public void deInitializeGreetings()
    {
    	employeeDao=null;
    }
    
    @Test // test cases
    public void testStore()
    {
    	Employee employee1=new Employee(0,"A",45000);
    	Employee storedEmployee = employeeDao.save(employee1);
    	assertTrue(storedEmployee.getId()!=0);
    }
    
    @Test
    public void testFindById()
    {
    	Employee employee1=new Employee(0,"A",45000);
    	Employee storedEmployee = employeeDao.save(employee1);
    	Employee foundEmployee=employeeDao.findById(storedEmployee.getId());
    	assertEquals(storedEmployee.getId(),foundEmployee.getId());
    }
    
    @Test
    public void testFindByAll()
    {
    	Employee employee1=new Employee(0,"A",45000);
    	Employee employee2=new Employee(0,"B",45000);
    	 employeeDao.save(employee1);
    	 employeeDao.save(employee2);
    	
    	int size=employeeDao.findAll().size();
    	assertTrue(size>=2);
    }
    
    @Test
    public void testDelete()
    {
    	Employee employee1=new Employee(0,"A",45000);
    	Employee employee2=new Employee(0,"B",45000);
    	Employee employee3=new Employee(0,"B",45000);
    	 employeeDao.save(employee1);
    	 employeeDao.save(employee2);
    	 employeeDao.save(employee3);
    	 int before=employeeDao.findAll().size();
    	employeeDao.delete(employee2.getId());
    	int after=employeeDao.findAll().size();
    	assertTrue(after<before);
    	
    }
}
