package com.pr.jpa.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pr.jpa.demo.entity.Course;
import com.pr.jpa.demo.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	
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
	
	
	
	public Course  save(Course course) {
		if(course.getId() == 0) {
			em.persist(course);
		}else {
			em.merge(course);
		}
		
		return course; 
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

	
	public void addHeadCodedReviewforCourse() {
		// get the course 1003
		Course course = findById(1003L);
		logger.info("course.getReviews() --> {}" , course.getReviews());
		
		
		//add 2 reviews
		Review review1 = new Review("5", "Hatsoff...");
		Review review2 = new Review("3" , "Love the content...");
		
		
		//setting the Relationship
		course.addReview(review2);
		review1.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);
		
		//save it to the Database
		em.persist(review1);
		em.persist(review2);
	}
	
	public void addReviewforCourse(Long id , List<Review> reviews) {
		// get the course 1003
		Course course = findById(id);
		logger.info("course.getReviews() --> {}" , course.getReviews());
		
		
		for(Review review : reviews) {
		//setting the Relationship
		course.addReview(review);
		review.setCourse(course);
		em.persist(review);
		}
	
	}
	
	
	
	
}
