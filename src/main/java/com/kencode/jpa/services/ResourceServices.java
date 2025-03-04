package com.kencode.jpa.services;

import com.kencode.jpa.model.Lecture;
import com.kencode.jpa.model.Resource;
import com.kencode.jpa.model.Video;
import com.kencode.jpa.repositories.LectureRepository;
import com.kencode.jpa.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  public Lecture getLectureById(Integer id) {
    return lectureRepository.findById(id).orElse(null);
  }


}
