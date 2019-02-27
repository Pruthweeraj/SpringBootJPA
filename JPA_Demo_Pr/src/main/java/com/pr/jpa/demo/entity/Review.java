package com.pr.jpa.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;

	
	private String rating;

	private String description;

	
	protected Review() {}

	public Review(String rating ,String description) {
		this.rating =rating;
		this.description = description;
	}
	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Review[%s  %s]" ,rating , description);
	}
	
	

}