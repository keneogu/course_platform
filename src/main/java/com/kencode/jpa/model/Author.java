package com.kencode.jpa.model;

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
@Table(name = "authors")
@NamedQuery(
    name = "Author.findByNamedQuery",
    query = "select a from Author a where a.age >= :age"
)
@NamedQuery(
    name = "Author.updateByNamedQuery",
    query = "update Author a set a.age = :age"
)
public class Author extends BaseEntity{

    @Column(
            name = "f_name"
    )
    private String firstName;

    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private Integer age;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

//    @Column(
//            updatable = false,
//            nullable = false
//    )
//    private LocalDateTime createdAt;
//
//    @Column(
//            insertable = false
//    )
//    private LocalDateTime lastModified;
}
