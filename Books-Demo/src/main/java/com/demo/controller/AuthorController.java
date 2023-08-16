package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.AuthorInputDto;
import com.demo.entity.Author;
import com.demo.service.AuthorService;

/**
 * {@summary CRUD operations for Author}
 * 
 * @author Hetasvi.Ahir
 *
 */
@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	public AuthorService authorService;

	/**
	 * 
	 * @return {@summary Returns List of Authors}
	 */
	@GetMapping("/all")
	public List<Author> getAll() {
		return authorService.getAllAuthor();
	}

	/**
	 * 
	 * @param author
	 * @return {@summary Save author to the database}
	 */
	@PostMapping("/save")
	public Author saveAuthor(@RequestBody AuthorInputDto author) {
		Author author2 = new Author();
		author2.setName(author.getName());
		return authorService.createAuthor(author2);
	}

	/**
	 * 
	 * @param id
	 * @return {@summary Returns Author by Id}
	 */
	@GetMapping("/getById/{id}")
	public Author getById(@PathVariable("id") Long id) {

		return authorService.getAuthorById(id);
	}

	/**
	 * 
	 * @param input
	 * @return {@summary Updates Author }
	 */
	@PostMapping("/update")
	public Author updateAuthor(@RequestBody Author input) {
		Author author = new Author();
		author.setId(input.getId());
		author.setName(input.getName());
		return authorService.updateAuthor(author);
	}

	/**
	 * 
	 * @param id
	 * @return {@summary Returns Success or failure message after deleting an
	 *         author}
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {

		return authorService.deleteAuthorById(id);
	}

}
