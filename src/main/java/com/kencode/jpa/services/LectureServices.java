package com.kencode.jpa.services;

import com.kencode.jpa.model.Course;
import com.kencode.jpa.model.Lecture;
import com.kencode.jpa.model.Section;
import com.kencode.jpa.repositories.LectureRepository;
import com.kencode.jpa.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureServices {

  @Autowired
  LectureRepository lectureRepository;

  @Autowired
  SectionRepository sectionRepository;

  public Lecture createLecture(Lecture lecture) {
    return lectureRepository.save(lecture);
  }

  public Section getSectionById(Integer id){
    return sectionRepository.findById(id).orElse(null);
  }

}
