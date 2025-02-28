package com.kencode.jpa.repositories;

import com.kencode.jpa.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Integer> {
  List<Section> findByCourseId(Integer courseId);
}
