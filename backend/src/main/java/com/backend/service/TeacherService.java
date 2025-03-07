package com.backend.service;

import com.backend.model.Teacher;
import com.backend.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    public Teacher addTeacher(Teacher teacher) {
        // 같은 이름의 교사가 있는지 확인
        Optional<Teacher> existingTeacher = teacherRepository.findByTeacherName(teacher.getTeacherName());
        if (existingTeacher.isPresent()) {
            throw new IllegalStateException("이미 등록된 교사 이름입니다: " + teacher.getTeacherName());
        }
        return teacherRepository.save(teacher);
    }
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public Optional<Teacher> findByTeacherName(String teacherName) {
        return teacherRepository.findByTeacherName(teacherName);
    }

}