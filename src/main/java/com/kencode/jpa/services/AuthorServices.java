package com.kencode.jpa.services;


import com.kencode.jpa.model.Author;
import com.kencode.jpa.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServices {

  @Autowired
  AuthorRepository authorRepository;

  public List<Author> getAuthors() {
    return authorRepository.findAll();
  }

  public Optional<Author> getAuthor(Integer id) {
    return authorRepository.findById(id);
  }

  public boolean isExists(Integer id) {
    return authorRepository.existsById(id);
  }

  public Author save(Author author) {
    return authorRepository.save(author);
  }

}
