package com.pr.jpa.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.pr.jpa.demo.entity.Course;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaDemoApplication.class)
public class  NativeQueryTest{
	
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());


	@Autowired
	EntityManager em;
	
	@Test
	public void nativeQuery_basic() {
	 Query query = em.createNativeQuery("select * from Course" , Course.class);	
	List  resultList = query.getResultList();
	logger.info("Select * from course --> {}" , resultList);
	
	}
	
	@Test
	public void nativeQuery_positioned_parameter(){
	Query query = em.createNativeQuery("Select * from Course where id = ?" , Course.class);
	query.setParameter(1, 1001);
	List resultList = query.getResultList();
	logger.info("Select * from Course where id = ?--> {}" , resultList);
	}
	
	@Test
	public void nativeQuery_named_parameter(){
		Query query = em.createNativeQuery("Select * from Course where id = :id", Course.class );
		query.setParameter("id"	, 1002L);
		List resultList = query.getResultList();
		logger.info("Select * from Course where id = ? --> {}" , resultList);	
	}
	
	@Test
	@Transactional
	public void native_query_to_update() {
		Query query = em.createNativeQuery("Update Course set updated_time =sysdate()");
		int numberOfRowUpdated = query.executeUpdate();
		logger.info("numberOfRowUpdated --> {}" , numberOfRowUpdated);
	}

	
	
	
	
	
}
