package com.kencode.jpa.controllers;

import com.kencode.jpa.model.Author;
import com.kencode.jpa.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthorController {

  @Autowired
  AuthorServices authorServices;

  @PostMapping("/authors")
  public Author createAuthor(@RequestBody Author author) {
    return authorServices.save(author);
  }

  @PutMapping("/authors/{id}")
  public Author updateAuthor(@PathVariable("id") Integer id, @RequestBody Author author) {
    if(!authorServices.isExists(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
    }
    author.setId(id);
    return authorServices.save(author);
  }

  @PatchMapping("/authors/{id}")
  public Author patchAuthor(@PathVariable("id") Integer id, @RequestBody Author author) {
    if(!authorServices.isExists(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
    }
    author.setId(id);
    return authorServices.partialUpdate(id,author);
  }

  @GetMapping("/authors")
  public List<Author> getAuthors() {
    return authorServices.getAuthors();
  }

  @GetMapping("/authors/{id}")
  public Optional<Author> getAuthor(@PathVariable("id") Integer id) {
    return authorServices.getAuthor(id);
  }

}
