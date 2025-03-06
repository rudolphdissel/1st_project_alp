package com.backend.controller;

import com.backend.model.Student;
import com.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
    //     studentService.deleteStudent(id);
    //     return ResponseEntity.noContent().build();
    // }

    @GetMapping("/students")
    public List<Student> getStudentAll() {
        return studentService.getAllStudents();
    }
    
}