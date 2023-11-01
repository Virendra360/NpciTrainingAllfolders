package com.npci.controller;

import com.npci.beans.Employee;
import com.npci.collection_exception.EmployeeNotFoundException;
import com.npci.dao.EmployeeDao;
import com.npci.service.EmployeeService;
import com.npci.service.EmployeeServiceImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestControllerFromMain {
	public static void main(String[] args) {
		
       ApplicationContext context= new ClassPathXmlApplicationContext("spring-orm-beans.xml");
       // Controller depends on service
        EmployeeService service=(EmployeeService) context.getBean("service");
       try {
    	   System.out.println("___Adding all employees__"); 
           List<Integer> idList=service.createEmployees(new Employee(0,"D",20000),new Employee(0,"A",10000),new Employee(0,"F",20000));
           System.out.print("[");
           for(int id:idList)
   	       {
   	    	   System.out.print(" "+id);
   	       }
           System.out.println("]");
           
           System.out.println("___Finding all employees__"); 
           List<Employee> employyesList= service.findEmployees();
   	       for(Employee e:employyesList)
   	       {
   	    	   System.out.println(e);
   	       }
   	       
   	      System.out.println("___Finding Employee By name__"); 
   	       List<Employee> listemplbyname= service.findEmployeesByName("A");
   	       for(Employee e:listemplbyname)
   	       {
   	    	   System.out.println(e);
   	       }
   	       
   	       System.out.println("Creating Employee"); 
   	       Employee empbycreate = service.createEmployee(new Employee(0,"k",20000) );
   	       System.out.println(empbycreate);
   	       
   	       System.out.println("___Finding Employee By id"); 
   	       Employee empbyid=service.findEmployee(17);
   	       System.out.println(empbyid);
   	       
   	       System.out.println("___Deleting Employee By id"); 
   	       service.deleteEmployee(17);
   	       
       }
       catch(EmployeeNotFoundException e)
       {
    	   System.out.println("Error :"+e);
       }
	       
	       
	       
	       
	}
}
