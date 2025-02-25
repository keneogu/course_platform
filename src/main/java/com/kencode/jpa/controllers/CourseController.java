package com.kencode.jpa.controllers;

import com.kencode.jpa.model.Course;
import com.kencode.jpa.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

  @Autowired
  CourseServices courseServices;

  @PostMapping("/courses")
  public Course createCourse(@RequestBody Course course) {
    return courseServices.save(course);
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

}
