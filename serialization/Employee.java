package com.serialization;

import java.io.Serializable;

public class Employee implements Serializable {
	//Below three variables are used in WhatPix.java class
	public int x;
	public static int y;
	protected static int z;
	
	public static int count=0;
	public Employee(){
		count++;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4968047240850725303L;
	/**
	 * 
	 */
	private String name;
	private int id;
	transient private int salary;
	private String password;

	@Override
	public String toString() {
		return "Employee{name=" + name + ",id=" + id + ",salary=" + salary
				+ "}";
	}

	// getter and setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}