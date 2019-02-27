package com.pr.jpa.demo;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pr.jpa.demo.entity.Course;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaDemoApplication.class)
public class  NamedQueryTest{
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());


	@Autowired
	EntityManager em;
	
	@Test
	public void NamedQuery_basic() {
	List resultList = em.createNamedQuery("find_all_course").getResultList();	
	logger.info("Select c from c --> {}" , resultList);
	
	}
	
	@Test
	public void NamedQuery_typed(){
		List<Course> resultList = em.createNamedQuery("find_all_course" , Course.class).getResultList();
		logger.info("Select c from c --> {}" , resultList);
	}
	
	@Test
	public void NamedQuery_where(){
		List<Course> resultList = em.createNamedQuery("find_course_in_100_steps" , Course.class).getResultList();
		logger.info("Select c from c where name like '%100 steps'--> {}" , resultList);
	}

	
	
	
}
