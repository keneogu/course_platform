package com.kencode.jpa.repositories;

import com.kencode.jpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
