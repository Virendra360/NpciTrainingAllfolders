package com.npci.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// import all annotaions from jakarta/javax.persistence package
@Entity
@Table(name="employee")
public class Employee {
	// @Column annotations not required when name in database and variable are same
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // auto-geneartes the id based on auto_increment
	@Column(name="id")
    private int id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="salary")
    private double salary;
    // 2 constructors and getters and setters
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
    
	
}
