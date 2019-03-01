package com.pr.jpa.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pr.jpa.demo.entity.Course;
import com.pr.jpa.demo.entity.Student;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaDemoApplication.class)
public class  JPQLtest{
	
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());


	@Autowired
	EntityManager em;
	
//	@Test
//	public void jpql_basic() {
//	List resultList = em.createQuery("Select c from Course c").getResultList();	
//	logger.info("Select c from c --> {}" , resultList);
//	
//	}
//	
//	@Test
//	public void jpql_typed(){
//		List<Course> resultList = em.createQuery("select c from Course c" , Course.class).getResultList();
//		logger.info("Select c from c --> {}" , resultList);
//	}
//	
//	@Test
//	public void jpql_where(){
//		List<Course> resultList = em.createQuery("select c from Course c where name like '%100 steps'" , Course.class).getResultList();
//		logger.info("Select c from c where name like '%100 steps'--> {}" , resultList);
//	}
//
//	
//	@Test
//	public void jpql_course_without_student() {
//		List<Course> resultList = em.createQuery("Select c from Course c where c.students is empty" , Course.class).getResultList();
//		logger.info("course_without_student()--> {}" , resultList);
//	}
//	
//	@Test
//	public void jpql_course_atlist_two_student() {
//		List<Course> resultList = em.createQuery("Select c from Course c where size(c.students) >= 2" , Course.class).getResultList();
//		logger.info("course_without_student()--> {}" , resultList);
//	}
//	
//	@Test
//	public void jpql_course_orderBy_student() {
//		List<Course> resultList = em.createQuery("Select c from Course c order by size(c.students) " , Course.class).getResultList();
//		logger.info("course_without_student()--> {}" , resultList);
//	}
//	
//	@Test
//	public void jpql_course_decendingOrder_student() {
//		List<Course> resultList = em.createQuery("Select c from Course c  order by size(c.students) desc" , Course.class).getResultList();
//		logger.info("course_without_student()--> {}" , resultList);
//	}
//	
//	@Test
//	public void jpql_student_with_passport_in_certion_partten() {
//		List<Student> resultList = em.createQuery("Select s from Student s where s.passport.number like '%445%'   " , Student.class).getResultList();
//		logger.info("jpql_student_with_passport_in_certion_partten( --> {}" , resultList);
//	}
//	
	//like
	//BETWEEN 100 and 1000
	//IS NULL
	//upper , lower, trim , length 
	
	
	
	
	//JOIN 
	//LEFT JOIN
	//CROSS JOIN
	@Test
	public void join() {
		 Query query = em.createQuery("Select c , s from Course c JOIN c.students s ");
		 List<Object[]> resultList = query.getResultList();
		logger.info("JOIN ResultRows --> {}" , resultList.size());
		
		for (Object[] result : resultList) {
			logger.info("Join results:--> {} " ,result[0]);
			logger.info("Join results:--> {} " ,result[1]);
		}
	}
	
	
	@Test
	public void left_join() {
		 Query query = em.createQuery("Select c , s from Course c LEFT JOIN c.students s ");
		 List<Object[]> resultList = query.getResultList();
		logger.info("Left_JOIN ResultRows --> {}" , resultList.size());
		
		for (Object[] result : resultList) {
			logger.info("cross_Join results:--> {} " ,result[0]);
			logger.info("cross_Join results:--> {} " ,result[1]);
		}
	}
	
	
	@Test
	public void cross_join() {
		 Query query = em.createQuery("Select c , s from Course c, Student s ");
		 List<Object[]> resultList = query.getResultList();
		logger.info("Cross_JOIN ResultRows --> {}" , resultList.size());
		
		for (Object[] result : resultList) {
			logger.info("cross_Join results:--> {} " ,result[0]);
			logger.info("cross_Join results:--> {} " ,result[1]);

		}
	}
	
	
	
	
}
