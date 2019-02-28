package com.pr.jpa.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pr.jpa.demo.entity.Passport;
import com.pr.jpa.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	//private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	EntityManager em;

	//find student by id
	public Student findById(long id) {
		return em.find(Student.class, id);
	}
	
	//Delete a student 
	public void deleteById(long id) {
		Student student = findById(id);
		em.remove(student);
	}
	
	public Student  save(Student student) {
		if(student.getId() == 0) {
			em.persist(student);
		}else {
			em.merge(student);
		}
		
		return student; 
	}
	

	
	
	public void saveStudentWithPassport() {
	
		Passport passport = new Passport("XM112233");
		em.persist(passport);
		
		Student student = new Student("Susu");
		
		student.setPassport(passport);
		em.persist(student);
		
		
	}
	
	

	public void  someOperationToUnderstandTransactionalPersistenceContext() {
		//Database operation  1 - Retrieve Student
		Student student = em.find(Student.class, 2001L);
		//Persistence Context(student)
		
		
	    //Database operation  2 - Retrieve passport
		Passport passport = student.getPassport();
		//Persistence Context(student,passport)
		
		//Database operation  3 - Update passport
		passport.setNumber("MM121212");
		//Persistence Context(student,passport++)
		
		//Database operation  4 - Update student
		student.setName("Susu-Updated");
		//Persistence Context(student++,passport++)
	}
	
}
