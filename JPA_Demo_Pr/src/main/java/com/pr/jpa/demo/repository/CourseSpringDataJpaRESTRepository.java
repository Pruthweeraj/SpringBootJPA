package com.pr.jpa.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pr.jpa.demo.entity.Course;

@RepositoryRestResource
public interface CourseSpringDataJpaRESTRepository extends JpaRepository<Course, Long>{

	List<Course> findByName(String name);
	List<Course> findByNameAndId(String name , long id);
	List<Course> countByName(String name);
	List<Course> findByNameOrderByIdDesc(String name);
	List<Course> deleteByName(String name);
	
	@Query("Select c from Course c")
	List<Course> findAllByQueryx();
	
//	@Query(name = "Select * from Course c where name like '%50 steps' ", nativeQuery = true)
//	List<Course> findAllByNativeQueryx();
	
	@Query(name = "find_all_course")
	List<Course> findAllByNamedQueryx();
}
