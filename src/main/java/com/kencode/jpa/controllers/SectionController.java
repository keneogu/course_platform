package com.kencode.jpa.controllers;

import com.kencode.jpa.model.Course;
import com.kencode.jpa.model.Section;
import com.kencode.jpa.services.SectionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    newSection.setCourse(existingCourse);

    return sectionServices.createSection(newSection);
  }

  @PatchMapping("/course/sections/{id}")
  public Section partialUpdate(@PathVariable("id") Integer id, @RequestBody Section section) {
    if(!sectionServices.isExists(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
    }

    return sectionServices.partialUpdate(id, section);
  }

  @GetMapping("/course/{courseId}/sections")
  public List<Section> getSectionsByCourseId(@PathVariable("courseId") Integer courseId) {
    return sectionServices.getSectionsByCourseId(courseId);
  }

  @GetMapping("/course/{courseId}/sections/{sectionId}")
  public Section getSection(@PathVariable("courseId") Integer courseId, @PathVariable("sectionId") Integer sectionId) {
    return sectionServices.getSectionByCourseIdAndSectionId(courseId, sectionId);
  }

  @DeleteMapping("/course/{courseId}/sections/{sectionId}")
  public void deleteSection(@PathVariable("courseId") Integer courseId, @PathVariable("sectionId") Integer sectionId) {
    sectionServices.deleteSectionByCourseIdAndSectionId(courseId,sectionId);
  }

}
