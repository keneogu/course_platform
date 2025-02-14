package com.kencode.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "resources")
public class Resource extends BaseEntity {

//  @Id
//  @GeneratedValue
//  private Integer id;

  private String name;

  private int size;

  private String url;

  @OneToOne
  @JoinColumn(name = "lecture_id")
  private Lecture lecture;
}
