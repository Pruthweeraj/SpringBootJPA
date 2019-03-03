package com.pr.jpa.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties.Packages;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pr.jpa.demo.entity.Course;
import com.pr.jpa.demo.repository.CourseSpringDataJpaRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaDemoApplication.class)
public class  CourseSpringDataJpaTest{

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataJpaRepository repository;
	
	@Test
	public void findById_CoursePresent() {
		Optional<Course> courseOptional = repository.findById(1001l);
		logger.info("{}" ,courseOptional.isPresent());
		assertTrue(courseOptional.isPresent());
	}
	
	@Test
	public void findById_CourseNotPresent() {
		Optional<Course> courseOptional = repository.findById(2001L);
		logger.info("{}" , courseOptional.isPresent());
		assertFalse(courseOptional.isPresent());
	}
	
	@Test
	public void playing_arround_the_Spring_Riop(){
		Course course = new Course("Hibernat in 10 steps");
		repository.save(course);
		logger.info("\n Courses --> {}" ,repository.findAll() );
		course.setName("Hibernet in 10 steps-updated");
		repository.save(course);
		
		logger.info("\n CoursesUpdated  -->{}" , repository.findAll());
		
		logger.info("\n Course Count -->{}" , repository.count());
	}
	
	
	@Test
	public void sort(){
		Course course = new Course("Hibernat in 10 steps");
		repository.save(course);
		Sort sort = new Sort(Sort.Direction.DESC , "name");
		logger.info("\n Sort-Courses --> {}" ,repository.findAll(sort) );
		//Sort-Courses --> [Course name =Spring in 70 steps, Course name =Liqubase in 20 steps, Course name =Jpa in 50 steps, Course name =Hibernate in 40 steps, Course name =Hibernat in 10 steps]
	}
	
	@Test
	public void pagination(){
		Pageable firstPage = PageRequest.of(0, 2);
		logger.info("\n page-Courses --> {}" ,repository.findAll(firstPage.getSort()) );
		
		Pageable secondPage = firstPage.next();
		logger.info("\n next-page-Courses --> {}" ,repository.findAll(secondPage.getSort()) );
	}
	
	@Test
	@Transactional
	public void findById_firstLevelCache() {
		Optional<Course> courseOptional = repository.findById(1001l);
		logger.info("\n Course name{}" ,courseOptional.get());
		Optional<Course> courseOptional2 = repository.findById(1001l);
		logger.info("\n course name-Repeated{}" ,courseOptional2.get());
		assertTrue(courseOptional.isPresent());
	}
	
}
