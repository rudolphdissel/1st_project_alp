package com.backend.service;

import com.backend.model.Teacher;
import com.backend.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    // 🔹 1. 전체 조회 (Read)
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // 🔹 2. 개별 조회 (Read)
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    // 🔹 3. 새로운 데이터 추가 (Create)
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // 🔹 4. 데이터 수정 (Update)
    public Teacher updateTeacher(Long id, Teacher newTeacherData) {
        return teacherRepository.findById(id)
                .map(teacher -> {
                    teacher.setTeacherName(newTeacherData.getTeacherName());
                    return teacherRepository.save(teacher);
                })
                .orElseThrow(() -> new RuntimeException("Teacher not found with id " + id));
    }

    // 🔹 5. 데이터 삭제 (Delete)
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
