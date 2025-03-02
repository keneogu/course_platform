package com.kencode.jpa.repositories;

import com.kencode.jpa.model.Lecture;
import com.kencode.jpa.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {

  @Modifying
  @Query("SELECT l FROM Lecture l " +
      "JOIN l.section s " +
      "JOIN s.course c " +
      "WHERE c.id = :courseId AND s.id = :sectionId AND l.id = :lectureId")
  Optional<Lecture> getLectureByCourseIdAndSectionIdAndLectureId(
      @Param("courseId") Integer courseId,
      @Param("sectionId") Integer sectionId,
      @Param("lectureId") Integer lectureId
  );

  @Query("SELECT l FROM Lecture l " +
      "JOIN l.section s " +
      "JOIN s.course c " +
      "WHERE c.id = :courseId AND s.id = :sectionId")
  List<Lecture> getLecturesByCourseIdAndSectionId(
      @Param("courseId") Integer courseId,
      @Param("sectionId") Integer sectionId
  );
}
