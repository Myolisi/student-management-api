package com.webtonic.student_management_api.controller;

import com.webtonic.student_management_api.entity.Student;
import com.webtonic.student_management_api.service.StudentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    //inject student service
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //add new student record
    @PostMapping("/add")
    private Student add(@Validated @RequestBody Student student){
        return studentService.addStudent(student);
    }

    //get all students
    @GetMapping("/all")
    private List<Student> getAll(){
        return studentService.getStudentCourses();
    }
}
