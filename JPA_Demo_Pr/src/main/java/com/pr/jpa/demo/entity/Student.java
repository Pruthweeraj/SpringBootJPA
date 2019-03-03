package com.pr.jpa.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Student implements Serializable {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable=false)
	private String name;

	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE" , 
				joinColumns = @JoinColumn(name ="STUDENT_ID") ,
				inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	private List<Course> courses = new ArrayList<>() ;
	
	@OneToMany(mappedBy = "student")
	private List<Review> reviews = new ArrayList<>();
	
	
	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	
	
	
	protected Student() {}

	public Student(String name) {
		this.name = name;
	}
	
	

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
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("Student[%s]" , name);
	}
	
	

}
