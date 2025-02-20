package com.kencode.jpa.repositories;

import com.kencode.jpa.model.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

  @Modifying
  @Transactional
  @Query("update Author a set a.age = :age where a.id = :id")
  int updateAuthor(int age, int id);

  List<Author> findAllByFirstName(String fn);

  List<Author> findAllByFirstNameIgnoreCase(String fn);

  List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

  List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

  List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

  List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);
}
