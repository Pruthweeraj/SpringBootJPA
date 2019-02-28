package com.pr.jpa.demo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pr.jpa.demo.entity.Passport;
import com.pr.jpa.demo.entity.Student;
import com.pr.jpa.demo.repository.StudentRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaDemoApplication.class)
public class  StudentRepositoryTest{
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRrepository;
	
	@Autowired
	EntityManager em;
	
	
	//Session & SessionFactory
	//EntityManager & Persistence Context
	//Transactional
	
	@Test
	@Transactional
	public void someTest() {
		studentRrepository.someOperationToUnderstandTransactionalPersistenceContext();
	}


	
	@Test
	@Transactional
	public void retriveStudentAndAssocitedPassportDetails() {
		Student student = em.find(Student.class, 2002l);
		logger.info("student --> {}" ,student );
		logger.info("passport--> {}" ,student.getPassport());
	}
	
	
	@Test
	@Transactional
	public void retrivePassportAndAssociatedStudentDetails() {
		Passport passport = em.find(Passport.class, 4002L);
		logger.info("passport --> {}" ,passport );
		logger.info("student  --> {}" ,passport.getStudent());
	}
	
}
