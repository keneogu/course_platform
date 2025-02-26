package com.kencode.jpa.controllers;

import com.kencode.jpa.model.Author;
import com.kencode.jpa.model.Course;
import com.kencode.jpa.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CourseController {

  @Autowired
  CourseServices courseServices;

  @PostMapping("/courses")
  public Course createCourse(@RequestBody Course newCourse) {

    if (newCourse.getAuthors() == null || newCourse.getAuthors().isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Authors list cannot be empty");
    }

    List<Author> authorsToLink = newCourse.getAuthors().stream()
        .map(author -> {
          if(author.getId() != null) {
            Author existingAuthor = courseServices.findAuthorById(author.getId());
            if (existingAuthor != null) {
              return existingAuthor;
            }
          }
              Author byEmail = courseServices.findAuthorByEmail(author.getEmail());
              if (byEmail != null) {
                return byEmail; // Use existing author with matching email
              }
              Author newAuthor = new Author();
              newAuthor.setFirstName(author.getFirstName());
              newAuthor.setLastName(author.getLastName());
              newAuthor.setEmail(author.getEmail());
              newAuthor.setAge(author.getAge());
              return courseServices.saveAuthor(newAuthor);
        })
        .collect(Collectors.toList());

    Course courseToSave = new Course();
    courseToSave.setName(newCourse.getName());
    courseToSave.setDescription(newCourse.getDescription());
    courseToSave.setAuthors(authorsToLink);

    return courseServices.save(courseToSave);
  }

  @GetMapping("/courses")
  public List<Course> getCourses() {
    return courseServices.getCourses();
  }

  @PutMapping("/courses/{id}")
  public Course updateCourse(@PathVariable("id") Integer id, @RequestBody Course course) {
    if(!courseServices.isExists(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
    }
    course.setId(id);
    return courseServices.save(course);
  }

  @PatchMapping("/courses/{id}")
  public Course partialUpdate(@PathVariable("id") Integer id, @RequestBody Course course) {
    if(!courseServices.isExists(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
    }
    return courseServices.partialUpdate(id, course);
  }

  @DeleteMapping("/courses/{id}")
  public void deleteCourse(@PathVariable("id") Integer id) {
    courseServices.deleteCourse(id);
  }

}
