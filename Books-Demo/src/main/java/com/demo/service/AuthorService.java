package com.demo.service;

import java.util.List;

import com.demo.entity.Author;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
public interface AuthorService {
	/**
	 * 
	 * @param author
	 * @return {@summary Create Author}
	 */
	public Author createAuthor(Author author);

	/**
	 * 
	 * @return {@summary Returns List of Authors}
	 */
	public List<Author> getAllAuthor();

	/**
	 * 
	 * @param id
	 * @return {@summary Returns Author by id}
	 */
	public Author getAuthorById(Long id);

	/**
	 * 
	 * @param id
	 * @return {@summary Returns Success or Failure response}
	 */
	public String deleteAuthorById(Long id);

	/**
	 * 
	 * @param author
	 * @return {@summary Returns Updated Author}
	 */
	public Author updateAuthor(Author author);

}
