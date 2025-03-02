package com.kencode.jpa.repositories;

import com.kencode.jpa.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Integer> {
  List<Section> findByCourseId(Integer courseId);

  @Modifying
  @Query("DELETE FROM Section s WHERE s.id = :sectionId AND s.course.id = :courseId")
  void deleteSectionByCourseIdAndSectionId(@Param("courseId") Integer courseId, @Param("sectionId") Integer sectionId);

  @Modifying
  @Query("SELECT s FROM Section s WHERE s.id = :sectionId AND s.course.id = :courseId")
  Section getSectionByCourseIdAndSectionId(@Param("courseId") Integer courseId, @Param("sectionId") Integer sectionId);

}
