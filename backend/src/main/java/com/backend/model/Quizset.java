package com.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "quizset")
public class Quizset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizsetId;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    @Column(nullable = false)
    private String quizName;

    @Column(nullable = false)
    private int quizDiff;
}
