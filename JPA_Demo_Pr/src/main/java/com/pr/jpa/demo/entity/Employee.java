package com.pr.jpa.demo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "employeeType")
public abstract class Employee {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable=false)
	private String name;
	
	
	protected  Employee() {}

	protected  Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee name =" + name ;
	}
	
	

}
