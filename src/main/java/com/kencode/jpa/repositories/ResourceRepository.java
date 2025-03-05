package com.kencode.jpa.repositories;

import com.kencode.jpa.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

  @Modifying
  @Query("DELETE FROM Resource r WHERE r.id = :resId AND r.lecture.id = :lectureId")
  void deleteResource(@Param("lectureId") Integer lectureId, @Param("resId") Integer resId);

}
