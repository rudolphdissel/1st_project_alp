package com.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "student_diff")
public class StudentDiff {
    @EmbeddedId
    private StudentDiffId id;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "quizset_id", insertable = false, updatable = false)
    private Quizset quizset;

    @Column(nullable = false)
    private int scoreToDiff;

    @Column(nullable = false)
    private int score;

    @Column(nullable = false)
    private int setDiff;
}

@Embeddable
@Getter
@Setter
class StudentDiffId implements java.io.Serializable {
    private Long studentId;
    private Long quizsetId;
}
