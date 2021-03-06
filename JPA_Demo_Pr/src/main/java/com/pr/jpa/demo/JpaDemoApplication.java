package com.pr.jpa.demo;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pr.jpa.demo.repository.CourseRepository;
import com.pr.jpa.demo.repository.EmployeeRepository;
import com.pr.jpa.demo.repository.StudentRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

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
		
		//courseRepository.playWithEntityManager();
		
		//studentRepository.saveStudentWithPassport();
		
//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("5", "Hatsoff..."));
//		reviews.add(new Review("3" , "Love the content..."));
//		
	//	courseRepository.addReviewforCourse(1002l , reviews);
		
		
		/*
		 * employeeRepository.insertEmployee(new PartTimeEmployee("Anu" , new
		 * BigDecimal(50))); employeeRepository.insertEmployee(new
		 * FullTimeEmployee("Alochana" , new BigDecimal(1000)));
		 * logger.info("All Employees --> {}" ,
		 * employeeRepository.retriveAllEmployee());
		 */
		
		
		
		
		
	}

}
