package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Author;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
