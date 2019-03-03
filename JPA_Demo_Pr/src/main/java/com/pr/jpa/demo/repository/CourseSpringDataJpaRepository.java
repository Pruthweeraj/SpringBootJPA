package com.pr.jpa.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pr.jpa.demo.entity.Course;

@Repository
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{

	List<Course> findByName(String name);
	List<Course> findByNameAndId(String name , long id);
	List<Course> countByName(String name);
	List<Course> findByNameOrderByIdDesc(String name);
	List<Course> deleteByName(String name);
	
	@Query("Select c from Course c")
	List<Course> findAllByQueryx();
	
	/*
	 * @Query(name ="Select * from Course " ,nativeQuery = true) List<Course>
	 * findAllByNativeQueryx();
	 */
	
	@Query(name = "find_all_course")
	List<Course> findAllByNamedQueryx();
}
