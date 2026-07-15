package com.aicampus.placementportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aicampus.placementportal.entity.Student;
import com.aicampus.placementportal.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public boolean login(String studentId, String password) {

        return studentRepository.findByStudentId(studentId)
                .map(student -> student.getPassword().equals(password))
                .orElse(false);
    }
}