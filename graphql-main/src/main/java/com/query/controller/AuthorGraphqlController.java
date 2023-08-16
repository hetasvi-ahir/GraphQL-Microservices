package com.query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.query.dto.AuthorDto;
import com.query.inputs.AuthorInput;
import com.query.inputs.AuthorUpdateInput;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@Controller
public class AuthorGraphqlController {
	@Autowired
	private RestTemplate restTemplate;

	@QueryMapping("getAuthors")
	public List<AuthorDto> getAllAuthor() {

		ResponseEntity<List<AuthorDto>> exchange = restTemplate.exchange("http://localhost:8009/author/all",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<AuthorDto>>() {
				});

		List<AuthorDto> body = exchange.getBody();

		return body;

	}

	@MutationMapping("createAuthor")
	public AuthorDto saveBook(@Argument AuthorInput author) {

		ResponseEntity<AuthorDto> responseEntity = restTemplate.postForEntity("http://localhost:8009/author/save",
				author, AuthorDto.class);
		AuthorDto body = responseEntity.getBody();
		return body;
	}

	@QueryMapping("getAuthor")
	public AuthorDto getBookById(@Argument Long id) {

		ResponseEntity<AuthorDto> exchange = restTemplate.getForEntity("http://localhost:8009/author/getById/" + id,
				AuthorDto.class);
		AuthorDto body = exchange.getBody();
		return body;
	}

	@MutationMapping("updateAuthor")
	public AuthorDto updateBook(@Argument AuthorUpdateInput input) {
		ResponseEntity<AuthorDto> exchange = restTemplate
				.getForEntity("http://localhost:8009/author/getById/" + input.getId(), AuthorDto.class);
		AuthorDto body = exchange.getBody();

		AuthorDto updatedBook = new AuthorDto();

		if (body != null) {
			ResponseEntity<AuthorDto> responseEntity = restTemplate.postForEntity("http://localhost:8009/author/update",
					input, AuthorDto.class);
			updatedBook = responseEntity.getBody();
			return updatedBook;
		} else {
			return updatedBook;
		}

	}

	@MutationMapping("deleteAuthor")
	public String deleteBookById(@Argument Long id) {

		ResponseEntity<AuthorDto> exchange = restTemplate.getForEntity("http://localhost:8009/author/getById/" + id,
				AuthorDto.class);
		AuthorDto body = exchange.getBody();

		if (body != null) {
			restTemplate.delete("http://localhost:8009/author/delete/" + id);
			return "Author Deleted Successfully";
		} else {
			return "Delete Unsuccessful";
		}

	}

}
