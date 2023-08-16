package com.demo.dto;

import lombok.Data;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@Data
public class BookInputDto {
	private Long id;
	private String title;
	private String description;
	private Long author;
	private Long pages;
	private Long price;

}
