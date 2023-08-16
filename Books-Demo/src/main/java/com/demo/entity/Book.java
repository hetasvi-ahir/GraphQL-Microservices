package com.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	// private String author;

	private Long pages;
	private Long price;

	/*
	 * @OneToOne private Author author;
	 */

	@ManyToOne
	private Author author;
}
