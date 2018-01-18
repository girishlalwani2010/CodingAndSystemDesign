package com.ai1tutorial.java.serialization;

import java.io.Serializable;

class Employee implements Serializable {

	private static final long serialVersionUID = 1795150986868131928L;

	transient String name;
	static String empId = "XYZ";
	String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Employee(String name, String department) {
		super();
		this.name = name;
		this.department = department;
	}
}

