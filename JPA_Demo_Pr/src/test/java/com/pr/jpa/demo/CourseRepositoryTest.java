package com.pr.jpa.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.pr.jpa.demo.entity.Course;
import com.pr.jpa.demo.entity.Review;
import com.pr.jpa.demo.repository.CourseRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaDemoApplication.class)
public class  CourseRepositoryTest{

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;
	
	
	@Test
	public void findByIdBasic() {
	Course course = repository.findById(1001);
	assertEquals("Jpa in 50 steps", course.getName());
	}

	
	@Test
	@DirtiesContext
	public void deleteByIdBasic() {
		repository.deleteById(1003L);
		assertNull(repository.findById(1003l));
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager_test() {
		repository.playWithEntityManager();
	}

	@Test
	@Transactional
	public void retriveReviewForCourse() {
		Course course = repository.findById(1003L);
		logger.info(" ReviewForCourse --> {}" , course.getReviews());
	}
	
	@Test
	@Transactional
	public void retriveCourseforReview() {
		Review reviews = em.find(Review.class, 5002L);
		logger.info("reviews -->  {}" , reviews);
		logger.info("reviews -->  {}" , reviews.getCourse());
	}
	
	
}
