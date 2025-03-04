package com.kencode.jpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "lectures")
public class Lecture extends BaseEntity {

  private String name;

  @ManyToOne
  @JoinColumn(name = "section_id")
  @JsonIgnore
  private Section section;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "resource_id")
  @JsonBackReference
  private Resource resource;
}
