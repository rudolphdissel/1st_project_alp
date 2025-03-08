package com.backend.controller;

import com.backend.model.Student;
import com.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudentAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/teacher/{teacherId}")
    public List<Student> getStudentsByTeacherId(@PathVariable Long teacherId) {
        return studentService.getStudentsByTeacherId(teacherId);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        System.out.println("ㅇㅇㅇㅇ");
        return studentService.addStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}