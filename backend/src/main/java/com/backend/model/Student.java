package com.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Student {

    @ManyToOne  // 다대일 관계 (여러 학생이 한 선생님에게 속함)
    @JoinColumn(name = "teacher_id", nullable = false)  // 외래키 설정
    private Teacher teacher;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name")
    private String name;

    @Column(name = "gender")
    private String gender;
}