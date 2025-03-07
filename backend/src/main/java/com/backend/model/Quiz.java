package com.backend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    @ManyToOne
    @JoinColumn(name = "quizset_id", nullable = false)
    private Quizset quizset;

    @Column(nullable = false)
    private String rightAnswer;
}

