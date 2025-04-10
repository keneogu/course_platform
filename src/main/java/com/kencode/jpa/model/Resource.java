package com.kencode.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "resource_type")
@Table(name = "resources")
public class Resource {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  private int size;

  private String url;

  @OneToOne
  @JoinColumn(name = "lecture_id")
  @JsonManagedReference
  private Lecture lecture;
}
