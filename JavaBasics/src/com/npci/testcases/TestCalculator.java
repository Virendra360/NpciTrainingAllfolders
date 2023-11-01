package com.npci.testcases;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.npci.beans.Calculator;

// we created test package manually if we create from spring t will create automatically
public class TestCalculator {
   // test the add methods
	@Test
	public void testAdd()
	{
		Calculator c= new Calculator();
		int result = c.add(20, 30);
		int expected =20+30;
		assertEquals(expected,result);
	}
	
	// test sub methods
	@Test
	public void testSub()
	{
		Calculator c= new Calculator();
		int result = c.sub(30, 20);
		int expected =30-20;
		assertEquals(expected,result);
	}


}
