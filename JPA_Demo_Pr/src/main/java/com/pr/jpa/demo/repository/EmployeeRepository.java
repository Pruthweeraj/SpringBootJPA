package com.pr.jpa.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pr.jpa.demo.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	EntityManager em;

	public void insertEmployee(Employee employee) {
		em.persist(employee);
	}
	
	public List<Employee> retriveAllEmployee(){
		return em.createQuery("Select e from Employee e" , Employee.class)
				.getResultList();
	}
	
}
