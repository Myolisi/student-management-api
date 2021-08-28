package com.webtonic.student_management_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class CourseEntity {
    @Id
    @SequenceGenerator(name= "course_seq", sequenceName = "course_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_seq")
    private Long id;

    @NotBlank(message = "Course code is required")
    @Column(
            nullable = false,
            columnDefinition = "VARCHAR(5)"

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
}
