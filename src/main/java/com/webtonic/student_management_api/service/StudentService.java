package com.webtonic.student_management_api.service;

import com.webtonic.student_management_api.entity.Student;
import com.webtonic.student_management_api.repository.ICourseRepository;
import com.webtonic.student_management_api.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class StudentService {
    private final IStudentRepository studentRepository;
    private final ICourseRepository courseRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository, ICourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<Student> addStudent(List<Student> student){

        // add each student
        student.forEach(eachStudent -> {
            if(!eachStudent.getCourse().isEmpty()){
                courseRepository.saveAll(eachStudent.getCourse());
            }
        });

        return studentRepository.saveAll(student);
    }

    public List<Student> getStudentCourses(){
        return studentRepository.getStudentCourses();
    }
}
