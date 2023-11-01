package com.npci;

import java.time.LocalDate;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
	private  int id;
	private String name;
	private double salary;
	private  LocalDate birthday;
	
	
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, double salary, LocalDate birthday) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", birthday=" + birthday + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
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
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public int compareTo(Employee o) {
		return id-o.id;
	}
	
	

}
