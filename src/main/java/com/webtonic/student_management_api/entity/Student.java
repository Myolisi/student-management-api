package com.webtonic.student_management_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
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


    @NotBlank(message = "Last name is required.")
    @Length(min = 2, max = 60, message = "Last name should be between 2 and 50 characters long")
    @Column(
            nullable = false,
            columnDefinition = "VARCHAR(60)"
    )
    private String lastName;

    @NotNull(message = "Student number is required")
    @Column(
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long studentNumber;


    @ManyToMany
    private List<Course> course;
}
