package com.npci;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class TestSorting {
 public static void main(String[] args) {
	
	 Set<String> strings=new TreeSet<String>((x,y)->y.compareTo(x));
	 strings.add("Hello");
	 strings.add("hello");
	 strings.add("Hello");
	 strings.add("Test");
	 System.out.println(strings);
	 //sorting based on id implemented using comaprable
	 Set<Employee> employees=new TreeSet<>();
	 employees.add(new  Employee(666,"Zaheer",8000,LocalDate.parse("1970-10-05")));
	 employees.add(new  Employee(777,"Sachin",7500,LocalDate.parse("1972-06-12")));
	 employees.add(new  Employee(567,"Dravid",9700,LocalDate.parse("1970-12-11")));
	 
	 System.out.println(employees);
	 //sorting based on birthday
	 Set<Employee> employees1=new TreeSet<>((x,y)->x.getBirthday().compareTo(y.getBirthday()));
	 employees1.add(new  Employee(666,"Zaheer",8000,LocalDate.parse("1970-10-05")));
	 employees1.add(new  Employee(777,"Sachin",7500,LocalDate.parse("1972-06-12")));
	 employees1.add(new  Employee(567,"Dravid",9700,LocalDate.parse("1970-12-11")));
	 
	 System.out.println(employees1);
	 // sorting based on salary in descending order 
	 // Double have compare method
	 // we can't use compareTo bcs  getsalary() returning double not Double.
	 Set<Employee> employees2=new TreeSet<>((x,y)->Double.compare(y.getSalary(), x.getSalary()));
	 employees2.add(new  Employee(666,"Zaheer",8000,LocalDate.parse("1970-10-05")));
	 employees2.add(new  Employee(777,"Sachin",7500,LocalDate.parse("1972-06-12")));
	 employees2.add(new  Employee(567,"Dravid",9700,LocalDate.parse("1970-12-11")));
	 
	 System.out.println(employees2);
}
	
}
