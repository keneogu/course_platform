package com.kencode.jpa.controllers;

import com.kencode.jpa.model.Course;
import com.kencode.jpa.model.Lecture;
import com.kencode.jpa.model.Resource;
import com.kencode.jpa.model.Video;
import com.kencode.jpa.services.ResourceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class ResourceController {

  @Autowired
  ResourceServices resourceServices;

  @PostMapping("/video")
  public ResponseEntity<Resource> createVideo(@RequestBody Video video) {
    if(video.getLecture() == null || video.getLecture().getId() == null){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lecture cannot be empty");
    }

    Lecture existingLecture = resourceServices.getLectureById(video.getLecture().getId());
    if(existingLecture == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lecture id not recognized");
    }

    existingLecture.setResource(video);

    video.setLecture(existingLecture);

    return ResponseEntity.ok(resourceServices.saveVideo(video));
  }

}
