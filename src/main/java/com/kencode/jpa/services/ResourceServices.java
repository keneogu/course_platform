package com.kencode.jpa.services;

import com.kencode.jpa.model.Resource;
import com.kencode.jpa.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServices {

  @Autowired
  ResourceRepository resourceRepository;

  public Resource createResource(Resource resource){
    return resourceRepository.save(resource);
  }


}
