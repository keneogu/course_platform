package com.kencode.jpa.services;

import com.kencode.jpa.model.Author;
import com.kencode.jpa.model.Course;
import com.kencode.jpa.repositories.AuthorRepository;
import com.kencode.jpa.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CourseServices {

  @Autowired
  CourseRepository courseRepository;

  @Autowired
  AuthorRepository authorRepository;

  public List<Course> getCourses() {
    return courseRepository.findAll();
  }

  public Course save(Course course) {
    return courseRepository.save(course);
  }

  public boolean isExists(Integer id) {
    return courseRepository.existsById(id);
  }

  public Optional<Course> getCourse(Integer id) {
    return courseRepository.findById(id);
  }

  public Course partialUpdate(Integer id, Course course) {
    course.setId(id);

    return courseRepository.findById(id).map(existingBook -> {
      Optional.ofNullable(course.getName()).ifPresent(existingBook::setName);
      Optional.ofNullable(course.getDescription()).ifPresent(existingBook::setDescription);
      return courseRepository.save(existingBook);
    }).orElseThrow(() -> new RuntimeException("Book does not exist"));
  }

  public Author findAuthorById(Integer id) {
    return authorRepository.findById(id).orElse(null); // Return null if not found
  }

  public Author findAuthorByEmail(String email) {
    return authorRepository.findByEmail(email).orElse(null); // Return null if not found
  }

  public Author saveAuthor(Author author) {
    return authorRepository.save(author);
  }

  public void deleteCourse(Integer id) {
    courseRepository.deleteById(id);
  }

}
