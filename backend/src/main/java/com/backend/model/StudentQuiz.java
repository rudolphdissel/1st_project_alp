package com.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "student_quiz")
public class StudentQuiz {
    @EmbeddedId
    private StudentQuizId id;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "quiz_id", insertable = false, updatable = false)
    private Quiz quiz;

    @Column(nullable = true)
    private String studentAnswer;
}

@Embeddable
@Getter
@Setter
class StudentQuizId implements java.io.Serializable {
    private Long studentId;
    private Long quizId;
} 