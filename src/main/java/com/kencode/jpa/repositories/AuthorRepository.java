package com.kencode.jpa.repositories;

import com.kencode.jpa.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
  List<Author> findAllByFirstName(String fn);
}
