package com.parentlyx.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "performance")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int previousMark;
    private int currentMark;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Constructors
    public Performance() {
    }

    public Performance(int previousMark, int currentMark, Student student) {
        this.previousMark = previousMark;
        this.currentMark = currentMark;
        this.student = student;
    }

    // 🔥 Unique Parent-Friendly Interpretation Layer
    public String getPerformanceStatus() {

        if (currentMark > previousMark) {
            return "GREEN - Improving";
        } else if (currentMark == previousMark) {
            return "YELLOW - Stable";
        } else {
            return "RED - Needs Attention";
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPreviousMark() {
        return previousMark;
    }

    public void setPreviousMark(int previousMark) {
        this.previousMark = previousMark;
    }

    public int getCurrentMark() {
        return currentMark;
    }

    public void setCurrentMark(int currentMark) {
        this.currentMark = currentMark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
