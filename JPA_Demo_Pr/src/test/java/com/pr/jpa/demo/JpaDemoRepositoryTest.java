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
public class  JpaDemoRepositoryTest{

	@Autowired
	CourseRepository repository;
	
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


	
	
}
