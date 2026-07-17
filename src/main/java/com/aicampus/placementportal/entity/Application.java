package com.aicampus.placementportal.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "drive_id")
    private PlacementDrive placementDrive;

    private String status;

    private LocalDate appliedDate;

    public Application() {
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public PlacementDrive getPlacementDrive() {
        return placementDrive;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setPlacementDrive(PlacementDrive placementDrive) {
        this.placementDrive = placementDrive;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }
}
