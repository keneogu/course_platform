package com.kencode.jpa.services;

import com.kencode.jpa.model.Lecture;
import com.kencode.jpa.repositories.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureServices {

  @Autowired
  LectureRepository lectureRepository;

  public Lecture createLecture(Lecture lecture) {
    return lectureRepository.save(lecture);
  }
}
