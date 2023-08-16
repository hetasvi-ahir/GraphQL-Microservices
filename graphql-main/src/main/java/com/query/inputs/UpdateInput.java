package com.query.inputs;

import lombok.Data;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@Data
public class UpdateInput {

	private Long id;
	private String title;
	private Long price;
	private Long pages;
}
