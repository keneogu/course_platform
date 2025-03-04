package com.kencode.jpa.services;

import com.kencode.jpa.model.*;
import com.kencode.jpa.repositories.LectureRepository;
import com.kencode.jpa.repositories.ResourceRepository;
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

}
