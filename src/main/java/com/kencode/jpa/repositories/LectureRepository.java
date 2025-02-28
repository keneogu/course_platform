package com.kencode.jpa.repositories;

import com.kencode.jpa.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {

}
