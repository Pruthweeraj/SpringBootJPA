package com.pr.jpa.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.pr.jpa.demo.entity.Course;
import com.pr.jpa.demo.repository.CourseRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaDemoApplication.class)
public class  Jpa_Hibernate_Annotation_test{

	@Autowired
	CourseRepository repository;
	
	@Test
	public void ok() {
	
	
	}
	
	
}
