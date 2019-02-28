package com.pr.jpa.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable=false)
	private String name;

	@ManyToMany
	private List<Course> courses = new ArrayList<>() ;
	
	protected Student() {}

	public Student(String name) {
		this.name = name;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	
	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public void removeCourse(Course course) {
		this.courses.remove(course);
	}
	
	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("Student[%s]" , name);
	}
	
	

}
