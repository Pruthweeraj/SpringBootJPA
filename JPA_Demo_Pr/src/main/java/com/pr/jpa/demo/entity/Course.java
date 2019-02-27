package com.pr.jpa.demo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQuery(name ="find_course_in_100_steps" , query = "select c from Course c where name like '%100 steps'")
@NamedQuery(name ="find_all_course" , query="select c from Course c")
public class Course {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable=false)
	private String name;

	@CreationTimestamp
	private Timestamp createdTime;
	
	@UpdateTimestamp
	private Timestamp updatedTime;
	
	protected Course() {}

	public Course(String name) {
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
		return "Course name =" + name ;
	}
	
	

}
