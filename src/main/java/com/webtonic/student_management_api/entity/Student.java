package com.webtonic.student_management_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "student")
public class Student {
    @Id
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    private Long id;


    @NotBlank(message = "First name is required")
    @Length(min = 2, max = 60, message = "First name should be between 2 and 50 characters long")
    @Column(
            nullable = false,
            columnDefinition = "VARCHAR(60)"
    )
    private String firstName;


    @NotBlank(message = "Surname is required.")
    @Length(min = 2, max = 60, message = "Surname should be between 2 and 50 characters long")
    @Column(
            nullable = false,
            columnDefinition = "VARCHAR(60)"
    )
    private String surname;

    @NotNull(message = "Student number is required")
    @Column(
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long studentNumber;


    @ManyToMany
    private List<Course> course;
}
