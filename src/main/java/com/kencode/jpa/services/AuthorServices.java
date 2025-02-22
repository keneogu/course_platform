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

  public Optional<Author> getAuthor(Integer id) {
    return authorRepository.findById(id);
  }

  public boolean isExists(Integer id) {
    return authorRepository.existsById(id);
  }

  public Author save(Author author) {
    return authorRepository.save(author);
  }

  public Author partialUpdate(Integer id, Author author) {
    Optional<Author> optionalAuthor = authorRepository.findById(id);

    Author existingAuthor = optionalAuthor.get();

    if (author.getFirstName() != null) {
      existingAuthor.setFirstName(author.getFirstName());
    }
    if (author.getLastName() != null) {
      existingAuthor.setLastName(author.getLastName());
    }
    if (author.getEmail() != null) {
      existingAuthor.setEmail(author.getEmail());
    }
    if (author.getAge() != null) {
      existingAuthor.setAge(author.getAge());
    }
    return authorRepository.save(existingAuthor);
  }

  public void deleteAuthor(Integer id) {
    authorRepository.deleteById(id);
  }

}
