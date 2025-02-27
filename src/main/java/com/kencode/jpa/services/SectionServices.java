package com.kencode.jpa.services;

import com.kencode.jpa.model.Course;
import com.kencode.jpa.model.Section;
import com.kencode.jpa.repositories.CourseRepository;
import com.kencode.jpa.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
