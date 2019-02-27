package com.pr.jpa.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pr.jpa.demo.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;

	//find course by id
	public Course findById(long id) {
		return em.find(Course.class, id);
	}
	
	//Delete a course 
	public void deleteById(long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	//
}
