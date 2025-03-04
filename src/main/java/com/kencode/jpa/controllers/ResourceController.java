package com.kencode.jpa.controllers;

import com.kencode.jpa.model.*;
import com.kencode.jpa.services.ResourceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

  @PostMapping("/file")
  public ResponseEntity<Resource> createVideo(@RequestBody File file) {
    if(file.getLecture() == null || file.getLecture().getId() == null){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lecture cannot be empty");
    }

    Lecture existingLecture = resourceServices.getLectureById(file.getLecture().getId());
    if(existingLecture == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lecture id not recognized");
    }

    existingLecture.setResource(file);

    file.setLecture(existingLecture);

    return ResponseEntity.ok(resourceServices.saveFile(file));
  }

  @PostMapping("/text")
  public ResponseEntity<Resource> createVideo(@RequestBody Text text) {
    if(text.getLecture() == null || text.getLecture().getId() == null){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lecture cannot be empty");
    }

    Lecture existingLecture = resourceServices.getLectureById(text.getLecture().getId());
    if(existingLecture == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lecture id not recognized");
    }

    existingLecture.setResource(text);

    text.setLecture(existingLecture);

    return ResponseEntity.ok(resourceServices.saveText(text));
  }

  @GetMapping("/resources")
  public List<Resource> getResources() {
    return resourceServices.getAllResources();
  }

}
