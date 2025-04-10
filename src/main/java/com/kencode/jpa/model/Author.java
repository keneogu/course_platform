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
    @JsonIgnore
    private List<Course> courses;

}
