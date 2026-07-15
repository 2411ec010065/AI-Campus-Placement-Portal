package com.aicampus.placementportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.aicampus.placementportal.dto.LoginRequest;
import com.aicampus.placementportal.entity.Student;
import com.aicampus.placementportal.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
@Validated
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest request) {

        boolean success = studentService.login(
                request.getStudentId(),
                request.getPassword());

        if (success) {
            return ResponseEntity.ok("Login Successful");
        }

        return ResponseEntity.badRequest().body("Invalid Student ID or Password");
    }
}