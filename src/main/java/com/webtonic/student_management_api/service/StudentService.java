package com.webtonic.student_management_api.service;

import com.webtonic.student_management_api.entity.Student;
import com.webtonic.student_management_api.repository.ICourseRepository;
import com.webtonic.student_management_api.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final IStudentRepository studentRepository;
    private final ICourseRepository courseRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository, ICourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Student addStudent(Student student){
        if(!student.getCourse().isEmpty()){
            courseRepository.saveAll(student.getCourse());
        }
        return studentRepository.save(student);
    }

    public List<Student> getStudentCourses(){
        return studentRepository.getStudentCourses();
    }
}
