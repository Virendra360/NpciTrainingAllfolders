package com.npci.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingsTestCase {
    private static ApplicationContext context;
    
    private Greetings greetings; // to use for multiple test cases
    
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
    	 greetings =(Greetings)context.getBean("b1");
    }
    
    //runs after each case
    @AfterEach
    public void deInitializeGreetings()
    {
    	greetings=null;
    }
    
    @Test // test cases
    public void testGreetings()
    {
    	
    	String actual=greetings.greet("Alex", "Hindi");
    	assertEquals("Namaskar",actual);
    	actual=greetings.greet("Alex", "French");
    	assertEquals("Bonjour",actual);
    }
    
 
}
