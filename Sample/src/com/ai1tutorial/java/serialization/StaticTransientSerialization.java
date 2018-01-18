package com.ai1tutorial.java.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StaticTransientSerialization {

	public static void main(String[] args) {
		Employee employee = new Employee("Ajay", "Mortgage");
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(
			"D:\\Java\\Employee.txt"));
			out.writeObject(employee);
			out.close();
			System.out.println("Serialization of Employee object is completed");
			System.out.println("Serialized file is present in path  D:\\Java\\Employee.txt ");
			in = new ObjectInputStream(new FileInputStream("D:\\Java\\Employee.txt"));
			Employee desrlEmployee = (Employee) in.readObject();
			System.out.println("Employee Name " + desrlEmployee.getName());
			System.out.println("Employee Id " + desrlEmployee.empId);
			System.out.println("Employee Name " + desrlEmployee.getDepartment());
			System.out.println("DeSerialization of Employee object is completed");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
