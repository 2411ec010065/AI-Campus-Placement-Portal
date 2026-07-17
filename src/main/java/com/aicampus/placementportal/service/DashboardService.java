package com.aicampus.placementportal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aicampus.placementportal.dto.DashboardResponse;
import com.aicampus.placementportal.entity.Student;
import com.aicampus.placementportal.repository.StudentRepository;

@Service
public class DashboardService {

    @Autowired
    private StudentRepository studentRepository;

    public DashboardResponse getDashboard(String studentId) {

        Student student = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        DashboardResponse response = new DashboardResponse();

        // Student Info
        response.setFullName(student.getFullName());
        response.setStudentId(student.getStudentId());
        response.setDepartment(student.getDepartment());
        response.setYear(student.getYear());
        response.setCgpa(student.getCgpa());

        // Dashboard Statistics
        response.setResumeUploaded(student.getResumePath() != null);
        response.setProfileCompletion(calculateProfileCompletion(student));
        response.setApplications(0);
        response.setInterviews(0);
        response.setSelectedCompanies(0);

        // AI Message
        response.setAiMessage("Complete your profile to improve AI recommendations.");

        // Recent Drives (Dummy for now)
        List<Map<String, Object>> drives = new ArrayList<>();

        Map<String, Object> drive = new HashMap<>();
        drive.put("company", "Google");
        drive.put("role", "Software Engineer");
        drive.put("package", "24 LPA");

        drives.add(drive);

        response.setRecentDrives(drives);

        // Notifications (Dummy for now)
        List<Map<String, Object>> notifications = new ArrayList<>();

        Map<String, Object> notification = new HashMap<>();
        notification.put("title", "Welcome");
        notification.put("message", "Welcome to AI Campus Placement Portal.");

        notifications.add(notification);

        response.setNotifications(notifications);

        return response;
    }

    private Integer calculateProfileCompletion(Student student) {

        int score = 0;

        if (student.getFullName() != null) score += 15;
        if (student.getEmail() != null) score += 15;
        if (student.getPhone() != null) score += 15;
        if (student.getDepartment() != null) score += 10;
        if (student.getCgpa() != null) score += 10;
        if (student.getSkills() != null && !student.getSkills().isBlank()) score += 15;
        if (student.getResumePath() != null) score += 20;

        return score;
    }
}