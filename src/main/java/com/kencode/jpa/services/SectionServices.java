package com.kencode.jpa.services;

import com.kencode.jpa.model.Course;
import com.kencode.jpa.model.Section;
import com.kencode.jpa.repositories.CourseRepository;
import com.kencode.jpa.repositories.SectionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionServices {

  @Autowired
  SectionRepository sectionRepository;

  @Autowired
  CourseRepository courseRepository;

  public Section createSection(Section newSection) {
    return sectionRepository.save(newSection);
  }

  public Course getCourseById(Integer id){
    return courseRepository.findById(id).orElse(null);
  }

  public boolean isExists(Integer id) {
    return sectionRepository.existsById(id);
  }

  public Section partialUpdate(Integer id, Section section) {
    section.setId(id);

    return sectionRepository.findById(id).map(existingBook -> {
      Optional.ofNullable(section.getName()).ifPresent(existingBook::setName);
      Optional.ofNullable(section.getOrderSection()).ifPresent(existingBook::setOrderSection);
      Optional.ofNullable(section.getCourse()).ifPresent(existingBook::setCourse);
      return sectionRepository.save(existingBook);
    }).orElseThrow(() -> new RuntimeException("Book does not exist"));
  }

  public List<Section> getSectionsByCourseId(Integer courseId) {
    return sectionRepository.findByCourseId(courseId);
  }

  @Transactional
  public void deleteSectionByCourseIdAndSectionId(Integer courseId, Integer sectionId) {

    Section section = sectionRepository.findById(sectionId)
        .orElseThrow(() -> new RuntimeException("Section not found"));

    // Check if the section belongs to the specified course
    if (!section.getCourse().getId().equals(courseId)) {
      throw new RuntimeException("Section does not belong to the specified course");
    }

    // Delete the section
    sectionRepository.delete(section);
  }

  @Transactional
  public Section getSectionByCourseIdAndSectionId(Integer courseId, Integer sectionId) {
    // Find the section by sectionId
    Section section = sectionRepository.findById(sectionId)
        .orElseThrow(() -> new RuntimeException("Section not found"));

    // Check if the section belongs to the specified course
    if (!section.getCourse().getId().equals(courseId)) {
      throw new RuntimeException("Section does not belong to the specified course");
    }

    return sectionRepository.findById(section.getId()).orElse(null);
  }

}
