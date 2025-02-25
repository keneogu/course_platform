package com.kencode.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_sequence")
  @SequenceGenerator(name = "author_sequence", sequenceName = "author_sequence", allocationSize = 1)
  private Integer id;

  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private LocalDateTime lastModifiedAt;

  private String createdBy;

  private  String lastModifiedBy;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
    lastModifiedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    lastModifiedAt = LocalDateTime.now();
  }

}
