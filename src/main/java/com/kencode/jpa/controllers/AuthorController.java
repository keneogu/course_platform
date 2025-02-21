package com.kencode.jpa.controllers;

import com.kencode.jpa.model.Author;
import com.kencode.jpa.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthorController {

  @Autowired
  AuthorServices authorServices;

  @GetMapping("/authors")
  public List<Author> getAuthors() {
    return authorServices.getAuthors();
  }

  @GetMapping("/authors/{id}")
  public Optional<Author> getAuthor(@PathVariable("id") Integer id) {
    return authorServices.getAuthor(id);
  }

}
