package com.kencode.jpa.services;

import com.kencode.jpa.model.*;
import com.kencode.jpa.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServices {

  @Autowired
  ResourceRepository resourceRepository;

  @Autowired
  LectureRepository lectureRepository;

  public Resource saveResource(Resource resource){
    return resourceRepository.save(resource);
  }

  public Resource saveVideo(Video video) {
    return resourceRepository.save(video);
  }

  public Resource saveFile(File file) { return resourceRepository.save(file); }

  public Resource saveText(Text text) { return resourceRepository.save(text); }

  public Lecture getLectureById(Integer id) {
    return lectureRepository.findById(id).orElse(null);
  }

  public List<Resource> getAllResources() {
    return resourceRepository.findAll();
  }

  @Transactional
  public void deleteResource(Integer lectureId, Integer resId) {

    Lecture lecture = lectureRepository.findById(lectureId)
        .orElseThrow(() -> new RuntimeException("lecture not found"));

    Resource resource = resourceRepository.findById(resId).orElseThrow(() -> new RuntimeException("Resource video not found"));

    // Check if the lecture belongs to the specified course or if the lecture belongs to a specified lecture
    if (!resource.getLecture().getId().equals(lectureId) || !lecture.getResource().getId().equals(resId)) {
      throw new RuntimeException("Resource/Lecture does not belong to the specified Resource/Lecture");
    }

    if (resource.getLecture() != null) {
      resource.getLecture().setResource(null);
      lectureRepository.save(resource.getLecture()); // Update the lecture
    }

    resourceRepository.delete(resource);
  }

}
