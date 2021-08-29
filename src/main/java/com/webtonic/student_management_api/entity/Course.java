package com.webtonic.student_management_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @SequenceGenerator(name= "course_seq", sequenceName = "course_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_seq")
    private Long id;

    @NotBlank(message = "Course code is required")
    @Column(
            nullable = false,
            columnDefinition = "VARCHAR(10)"

    )
    private String code;

    @NotBlank(message = "Description code is required")
    @Column(
            nullable = false,
            columnDefinition = "VARCHAR(150)"
    )
    private String description;

    @NotNull(message = "Grade code is required")
    @Column(
            nullable = false,
            columnDefinition = "char(1)"
    )
    private char grade;

    @JsonIgnore //dont include this to results
    //create an associate table to store all the relations
    @ManyToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Student> student;
}
