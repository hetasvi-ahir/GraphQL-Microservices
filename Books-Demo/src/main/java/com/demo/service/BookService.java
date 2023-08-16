package com.demo.service;

import java.util.List;

import com.demo.entity.Book;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
public interface BookService {

	/**
	 * 
	 * @param book
	 * @return Book {@summary Returns the book we have added in database.}
	 */
	public Book createBook(Book book);

	/**
	 * 
	 * @return {@summary Returns the list of book from the database.}
	 */
	public List<Book> getAllBooks();

	/**
	 * 
	 * @param id
	 * @return {@summary Returns the book by id }
	 */
	public Book getBookById(Long id);

	/**
	 * 
	 * @param id
	 * @return {@summary Success or Fail message}
	 */
	public String deleteBookById(Long id);

	/**
	 * 
	 * @param book
	 * @return {@summary Updates the book }
	 */
	public Book updateBook(Book book);

}
