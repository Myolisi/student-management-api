package com.webtonic.student_management_api.controller;

import com.webtonic.student_management_api.entity.Course;
import com.webtonic.student_management_api.entity.Student;
import com.webtonic.student_management_api.repository.ICourseRepository;
import com.webtonic.student_management_api.repository.IStudentRepository;
import com.webtonic.student_management_api.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentControllerTest {

    @Autowired
    StudentService studentService;

    @MockBean
    Student student;
    @MockBean
    private Course course;

    @MockBean
    ICourseRepository iCourseRepository;

    @MockBean
    IStudentRepository iStudentRepository;



    @BeforeEach
    void setUp() {
        //create our student
       course =  Course.builder()
                .id(1L)
                .code("mp102")
                .description("Metaphysics")
                .grade('A')
                .student(Arrays.asList(student))
                .build();

        student = Student.builder()
                .id(1L)
                .firstName("James")
                .surname("May")
                .studentNumber(12345678L)
                .course(Arrays.asList(course))
                .build();
    }

    @Test
    public void canReturnStudentCourse(){

        // mock repo
        Mockito.when(iStudentRepository.getStudentCourses())
                .thenReturn(List.of(student));

        // evoke service to return all students
        List<Student> getAll = studentService.getStudentCourses();

        // Since we are checking the first element
        assertEquals(student, getAll.get(0));
    }

    @Test
    public void canCreateStudent(){

        // mock repo
        Mockito.when(iStudentRepository.saveAll(List.of(student)))
                .thenReturn(List.of(student));

        // evoke service to add students
        List<Student> getAll = studentService.addStudent(List.of(student));

        // we should get one student
        assertEquals(1, getAll.size());
    }
}