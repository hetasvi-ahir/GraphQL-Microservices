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

import com.query.dto.BookDto;
import com.query.inputs.BookInput;
import com.query.inputs.UpdateInput;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@Controller
public class BookGraphqlController {
	@Autowired
	private RestTemplate restTemplate;

	@MutationMapping("createBook")
	public BookDto saveBook(@Argument BookInput book) {

		ResponseEntity<BookDto> responseEntity = restTemplate.postForEntity("http://localhost:8009/books/save", book,
				BookDto.class);
		BookDto body = responseEntity.getBody();
		return body;
	}

	@QueryMapping("allBooks")
	public List<BookDto> getAll() {

		ResponseEntity<List<BookDto>> exchange = restTemplate.exchange("http://localhost:8009/books/getAll",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<BookDto>>() {
				});

		List<BookDto> body = exchange.getBody();

		return body;
	}

	@QueryMapping("getBook")
	public BookDto getBookById(@Argument Long bookId) {

		ResponseEntity<BookDto> exchange = restTemplate.getForEntity("http://localhost:8009/books/getById/" + bookId,
				BookDto.class);
		BookDto body = exchange.getBody();
		return body;
	}

	@MutationMapping("updateBook")
	public BookDto updateBook(@Argument UpdateInput input) {
		ResponseEntity<BookDto> exchange = restTemplate
				.getForEntity("http://localhost:8009/books/getById/" + input.getId(), BookDto.class);
		BookDto body = exchange.getBody();

		BookDto updatedBook = new BookDto();

		if (body != null) {
			ResponseEntity<BookDto> responseEntity = restTemplate.postForEntity("http://localhost:8009/books/update",
					body, BookDto.class);
			updatedBook = responseEntity.getBody();
			return updatedBook;
		} else {
			return updatedBook;
		}

	}

	@MutationMapping("deleteBook")
	public String deleteBookById(@Argument Long bookId) {

		ResponseEntity<BookDto> exchange = restTemplate.getForEntity("http://localhost:8009/books/getById/" + bookId,
				BookDto.class);
		BookDto body = exchange.getBody();

		if (body != null) {
			restTemplate.delete("http://localhost:8009/books/delete/" + bookId);
			return "Book Deleted Successfully";
		} else {
			return "Delete Unsuccessful";
		}

	}

}
