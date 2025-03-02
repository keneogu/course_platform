package com.kencode.jpa.services;

import com.kencode.jpa.model.Course;
import com.kencode.jpa.model.Lecture;
import com.kencode.jpa.model.Section;
import com.kencode.jpa.repositories.LectureRepository;
import com.kencode.jpa.repositories.SectionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

  @Transactional
  public Lecture getLectureByCourseIdAndSectionIdAndLectureId(Integer courseId, Integer sectionId, Integer lectureId) {

    // Find the Lecture by lectureId
    Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(() -> new RuntimeException("Lecture not found"));

    // Find the section by sectionId
    Section section = sectionRepository.findById(sectionId)
        .orElseThrow(() -> new RuntimeException("Section not found"));

    // Check if the section belongs to the specified course or if the lecture belongs to a specified section
    if (!section.getCourse().getId().equals(courseId) || !lecture.getSection().getId().equals(sectionId)) {
      throw new RuntimeException("Lecture/Section does not belong to the specified Section/Course");
    }

    return lectureRepository.findById(lecture.getId()).orElse(null);
  }

  @Transactional
  public List<Lecture> getLecturesByCourseIdAndSectionId(Integer courseId, Integer sourceId) {
    return lectureRepository.getLecturesByCourseIdAndSectionId(courseId,sourceId);
  }

}
