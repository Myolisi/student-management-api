package com.webtonic.student_management_api.repository;

import com.webtonic.student_management_api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    //get a student and course related
    @Query("SELECT s FROM Student s INNER JOIN s.course ")
    public List<Student> getStudentCourses();
}
