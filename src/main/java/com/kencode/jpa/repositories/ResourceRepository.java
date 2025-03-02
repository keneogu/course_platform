package com.kencode.jpa.repositories;

import com.kencode.jpa.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {
}
