package com.kencode.jpa.services;

import com.kencode.jpa.model.Author;
import com.kencode.jpa.model.Course;
import com.kencode.jpa.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServices {

  @Autowired
  CourseRepository courseRepository;

  public List<Course> getCourses() {
    return courseRepository.findAll();
  }

  public Course createCourse(Course course) {
    return courseRepository.save(course);
  }
}
