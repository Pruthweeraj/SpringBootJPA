package com.pr.jpa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pr.jpa.demo.repository.CourseRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	CourseRepository repository;

	//private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Course course = repository.findById(1001L);
		 * logger.info("\n Course 1001 -- >{}", course);
		 * 
		 * repository.deleteById(1002); logger.info("\n Course 1002 deleted ");
		 */
		
		//repository.playWithEntityManager();
		
		
	}

}
