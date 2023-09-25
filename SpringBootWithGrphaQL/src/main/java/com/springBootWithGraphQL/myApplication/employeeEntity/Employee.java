package com.springBootWithGraphQL.myApplication.employeeEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String fullName;
	private int age;
	private String address;
	
	public Employee(Integer id, String fullName, int age, String address) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.address = address;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", age=" + age + ", address=" + address + "]";
	}
	
	
}
