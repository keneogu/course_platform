package com.kencode.jpa.repositories;

import com.kencode.jpa.model.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

  @Transactional
  List<Author> findByNamedQuery(@Param("age") int age);

  @Modifying
  @Transactional
  void updateByNamedQuery(@Param("age") int age);

  @Modifying
  @Transactional
  @Query("update Author a set a.age = :age where a.id = :id")
  int updateAuthor(int age, int id);

  @Modifying
  @Transactional
  @Query("update Author a set a.age = :age")
  void  updateAllAuthorsAges(int age);

  Optional<Author> findByEmail(String email);

  List<Author> findAllByFirstName(String fn);

  List<Author> findAllByFirstNameIgnoreCase(String fn);

  List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

  List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

  List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

  List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);
}
