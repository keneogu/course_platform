package com.kencode.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "sections")
public class Section extends BaseEntity {

  @Column(nullable = false)
  private String name;

  private int orderSection;

  @ManyToOne
  @JoinColumn(name = "course_id")
  @JsonIgnore
  private Course course;

  @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
  private List<Lecture> lectures;
}
