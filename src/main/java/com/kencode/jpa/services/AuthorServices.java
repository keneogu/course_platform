package com.kencode.jpa.services;


import com.kencode.jpa.model.Author;
import com.kencode.jpa.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServices {

  @Autowired
  AuthorRepository authorRepository;

  public List<Author> getAuthors() {
    return authorRepository.findAll();
  }

//  public Optional<Author> getAuthor(int authorId) {
//    return authorRepository.findById(authorId);
//  }

}
