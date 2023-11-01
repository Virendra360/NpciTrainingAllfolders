package com.npci.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGreetings {
	public static void main(String[] args) {
		// to use  the object in the spring container- ApplicationContext
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		Greetings greetings=(Greetings)context.getBean("b1");
		String result=greetings.greet("Viren", "French");
		
		System.out.println(result);
		
		ClassPathXmlApplicationContext cpxtx=(ClassPathXmlApplicationContext)context;
		cpxtx.close();
	}
    
	
}
