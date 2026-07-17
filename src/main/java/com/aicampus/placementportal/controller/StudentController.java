package com.aicampus.placementportal.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.aicampus.placementportal.dto.LoginRequest;
import com.aicampus.placementportal.dto.UpdateStudentProfileRequest;
import com.aicampus.placementportal.entity.Student;
import com.aicampus.placementportal.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
@Validated
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Register Student
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Get All Students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get Student Profile
    @GetMapping("/profile/{studentId}")
    public Student getStudentProfile(@PathVariable String studentId) {
        return studentService.getStudentByStudentId(studentId);
    }

    // Update Student Profile
    @PutMapping("/profile/{studentId}")
    public Student updateStudentProfile(
            @PathVariable String studentId,
            @Valid @RequestBody UpdateStudentProfileRequest request) {

        return studentService.updateStudentProfile(studentId, request);
    }

    // Login
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

    // Upload Resume
    @PostMapping("/{studentId}/uploadResume")
    public ResponseEntity<?> uploadResume(
            @PathVariable String studentId,
            @RequestParam("file") MultipartFile file) {

        try {

            Student student = studentService.uploadResume(studentId, file);

            return ResponseEntity.ok(student);

        } catch (IOException e) {

            return ResponseEntity.badRequest()
                    .body("Unable to upload resume.");

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
}