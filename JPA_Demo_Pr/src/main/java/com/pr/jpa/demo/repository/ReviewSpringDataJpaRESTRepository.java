package com.pr.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pr.jpa.demo.entity.Review;

@RepositoryRestResource
public interface ReviewSpringDataJpaRESTRepository extends JpaRepository<Review, Long>{

	/*
	 * List<Review> findByName(String name); List<Review> findByNameAndId(String
	 * name , long id); List<Review> countByName(String name); List<Review>
	 * findByNameOrderByIdDesc(String name); List<Review> deleteByName(String name);
	 * 
	 * @Query("Select c from Review c") List<Review> findAllByQueryx();
	 * 
	 * // @Query(name = "Select * from Review c where name like '%50 steps' ",
	 * nativeQuery = true) // List<Review> findAllByNativeQueryx();
	 * 
	 * @Query(name = "find_all_course") List<Review> findAllByNamedQueryx();
	 */
}
