package com.kencode.jpa.controllers;

import com.kencode.jpa.model.Course;
import com.kencode.jpa.model.Section;
import com.kencode.jpa.services.SectionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class SectionController {

  @Autowired
  SectionServices sectionServices;

  @PostMapping("/course/sections")
  public Section createSection(@RequestBody Section newSection) {

    if(newSection.getCourse() == null || newSection.getCourse().getId() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course cannot be empty");
    }

    Course existingCourse = sectionServices.getCourseById(newSection.getCourse().getId());
    if (existingCourse == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found with ID: " + newSection.getCourse().getId());
    }

    // Create the new Section and associate it with the existing Course
    newSection.setCourse(existingCourse);

    return sectionServices.createSection(newSection);
  }

}
