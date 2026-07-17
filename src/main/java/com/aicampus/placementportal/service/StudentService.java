package com.aicampus.placementportal.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aicampus.placementportal.dto.UpdateStudentProfileRequest;
import com.aicampus.placementportal.entity.Student;
import com.aicampus.placementportal.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private final String UPLOAD_DIR = "uploads/resumes/";

    // ==============================
    // Register Student
    // ==============================

    public Student saveStudent(Student student) {

        if (studentRepository.existsByStudentId(student.getStudentId())) {
            throw new RuntimeException("Student ID already exists");
        }

        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        return studentRepository.save(student);
    }

    // ==============================
    // Get All Students
    // ==============================

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // ==============================
    // Get Student Profile
    // ==============================

    public Student getStudentByStudentId(String studentId) {

        return studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // ==============================
    // Update Student Profile
    // ==============================

    public Student updateStudentProfile(
            String studentId,
            UpdateStudentProfileRequest request) {

        Student student = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setFullName(request.getFullName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setDepartment(request.getDepartment());
        student.setYear(request.getYear());
        student.setCgpa(request.getCgpa());
        student.setSkills(request.getSkills());

        return studentRepository.save(student);
    }

    // ==============================
    // Login
    // ==============================

    public boolean login(String studentId, String password) {

        return studentRepository.findByStudentId(studentId)
                .map(student -> student.getPassword().equals(password))
                .orElse(false);
    }

    // ==============================
    // Resume Upload
    // ==============================

    public Student uploadResume(String studentId, MultipartFile file) throws IOException {

        Student student = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Files.createDirectories(Paths.get(UPLOAD_DIR));

        String originalName = file.getOriginalFilename();

        String fileName = UUID.randomUUID() + "_" + originalName;

        Path filePath = Paths.get(UPLOAD_DIR, fileName);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        student.setResumePath(fileName);

        return studentRepository.save(student);
    }
}