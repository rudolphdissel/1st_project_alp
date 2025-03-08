package com.backend.repository;

import com.backend.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByTeacher_TeacherId(Long teacherId); // 변경된 메서드명
}
