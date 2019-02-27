package com.pr.jpa.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pr.jpa.demo.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	//private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	
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
	
	public void playWithEntityManager() {
	
		Course course1 = new Course("pp in 100 steps");
		em.persist(course1);
		
		Course course2 = findById(1001);
		course2.setName("course 2 updated .");
		
		
		
		
		/*
		 * Course course1 = new Course("WebServices in 100 steps"); em.persist(course1);
		 * 
		 * Course course2 = new Course("WebServices in 100 steps"); em.persist(course2);
		 * em.flush();
		 * 
		 * 
		 * course1.setName("WebServices in 100 steps -Updated.");
		 * course2.setName("WebServices in 100 steps -Updated.");
		 * 
		 * em.refresh(course1);//after this line the course1 value will be refreshed to
		 * original value ,i.e "WebServices in 100 steps" .
		 * 
		 * em.flush();
		 * 
		 */		
		
		
	}
	
}
