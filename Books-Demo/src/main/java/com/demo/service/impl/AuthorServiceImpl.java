package com.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Author;
import com.demo.repository.AuthorRepository;
import com.demo.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	public AuthorRepository authorRepository;

	@Override
	public Author createAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public List<Author> getAllAuthor() {

		return authorRepository.findAll();
	}

	@Override
	public Author getAuthorById(Long id) {
		Optional<Author> findById = authorRepository.findById(id);
		Author author = findById.get();
		return author;
	}

	@Override
	public String deleteAuthorById(Long id) {

		try {
			authorRepository.deleteById(id);
			return "Delete Successful";
		} catch (Exception e) {
			return "Delete failure";
		}
	}

	@Override
	public Author updateAuthor(Author author) {
		Author author2 = new Author();
		Optional<Author> findById = authorRepository.findById(author.getId());
		if (findById.isPresent()) {
			author2 = findById.get();
		}

		author2.setId(author.getId());
		author2.setName(author.getName());

		Author result = authorRepository.save(author2);
		return result;
	}

}
