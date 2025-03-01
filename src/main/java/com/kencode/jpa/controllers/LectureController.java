package com.kencode.jpa.controllers;

import com.kencode.jpa.model.Course;
import com.kencode.jpa.model.Lecture;
import com.kencode.jpa.model.Section;
import com.kencode.jpa.services.LectureServices;
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
public class LectureController {

  @Autowired
  LectureServices lectureServices;

  @Autowired
  SectionServices sectionServices;

  @PostMapping("/course/section/lectures")
  public Lecture createLecture(@RequestBody Lecture newLecture) {
    if(newLecture.getSection() == null || newLecture.getSection().getId() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Section cannot be empty");
    }

    Section existingSection = lectureServices.getSectionById(newLecture.getSection().getId());
    if (existingSection == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Section not found with ID: " + newLecture.getSection().getId());
    }

    newLecture.setSection(existingSection);

    return lectureServices.createLecture(newLecture);
  }
}
