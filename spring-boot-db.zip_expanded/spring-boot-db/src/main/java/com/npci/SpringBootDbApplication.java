package com.npci;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.npci.beans.Employee;
import com.npci.service.EmployeeService;

@SpringBootApplication
public class SpringBootDbApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(SpringBootDbApplication.class, args);
		// bean id of EmployeeServiceImpl is  service
//		EmployeeService service=(EmployeeService) ctx.getBean("service");
//		
//		// storing the employee
//		Employee employee=service.createEmployee(new Employee(0,"ABC",42000));
//		System.out.println("Stored Employee is: "+employee.getId());
//		
//		
//		// retrieve all data
//		List<Employee> employees= service.findEmployees();
//		employees.forEach(item->System.out.println("Id :"+item.getId()));
//	
		}

}
