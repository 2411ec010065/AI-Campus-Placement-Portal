package com.aicampus.placementportal.dto;

import java.util.List;
import java.util.Map;

public class DashboardResponse {

    // Student Info
    private String fullName;
    private String studentId;
    private String department;
    private Integer year;
    private Double cgpa;

    // Dashboard Statistics
    private Integer profileCompletion;
    private Boolean resumeUploaded;
    private Integer applications;
    private Integer interviews;
    private Integer selectedCompanies;

    // Dashboard Sections
    private List<Map<String, Object>> recentDrives;
    private List<Map<String, Object>> notifications;

    // AI Section
    private String aiMessage;

    public DashboardResponse() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getProfileCompletion() {
        return profileCompletion;
    }

    public void setProfileCompletion(Integer profileCompletion) {
        this.profileCompletion = profileCompletion;
    }

    public Boolean getResumeUploaded() {
        return resumeUploaded;
    }

    public void setResumeUploaded(Boolean resumeUploaded) {
        this.resumeUploaded = resumeUploaded;
    }

    public Integer getApplications() {
        return applications;
    }

    public void setApplications(Integer applications) {
        this.applications = applications;
    }

    public Integer getInterviews() {
        return interviews;
    }

    public void setInterviews(Integer interviews) {
        this.interviews = interviews;
    }

    public Integer getSelectedCompanies() {
        return selectedCompanies;
    }

    public void setSelectedCompanies(Integer selectedCompanies) {
        this.selectedCompanies = selectedCompanies;
    }

    public List<Map<String, Object>> getRecentDrives() {
        return recentDrives;
    }

    public void setRecentDrives(List<Map<String, Object>> recentDrives) {
        this.recentDrives = recentDrives;
    }

    public List<Map<String, Object>> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Map<String, Object>> notifications) {
        this.notifications = notifications;
    }

    public String getAiMessage() {
        return aiMessage;
    }

    public void setAiMessage(String aiMessage) {
        this.aiMessage = aiMessage;
    }
}
