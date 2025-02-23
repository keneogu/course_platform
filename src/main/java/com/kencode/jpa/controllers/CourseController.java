package com.kencode.jpa.controllers;

import com.kencode.jpa.model.Course;
import com.kencode.jpa.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CourseController {

  @Autowired
  CourseServices courseServices;

  @PostMapping("/courses")
  public Course createCourse(@RequestBody Course course) {
    return courseServices.createCourse(course);
  }
}
