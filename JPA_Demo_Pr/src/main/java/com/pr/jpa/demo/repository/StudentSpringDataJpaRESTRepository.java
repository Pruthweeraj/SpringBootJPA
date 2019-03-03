package com.pr.jpa.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pr.jpa.demo.entity.Student;

@RepositoryRestResource
public interface StudentSpringDataJpaRESTRepository extends JpaRepository<Student, Long>{

	List<Student> findByName(String name);
	List<Student> findByNameAndId(String name , long id);
	List<Student> countByName(String name);
	List<Student> findByNameOrderByIdDesc(String name);
	List<Student> deleteByName(String name);
	
	@Query("Select c from Student c")
	List<Student> findAllByQueryx();
	
//	@Query(name = "Select * from Student c where name like '%50 steps' ", nativeQuery = true)
//	List<Student> findAllByNativeQueryx();
	
	@Query(name = "find_all_course")
	List<Student> findAllByNamedQueryx();
}
