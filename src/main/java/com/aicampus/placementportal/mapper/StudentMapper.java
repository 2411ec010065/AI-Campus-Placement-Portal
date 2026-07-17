package com.aicampus.placementportal.mapper;

import org.springframework.stereotype.Component;

import com.aicampus.placementportal.dto.StudentProfileResponse;
import com.aicampus.placementportal.entity.Student;

@Component
public class StudentMapper {

    public StudentProfileResponse toProfileResponse(Student student) {

        StudentProfileResponse response = new StudentProfileResponse();

        response.setId(student.getId());
        response.setFullName(student.getFullName());
        response.setStudentId(student.getStudentId());
        response.setEmail(student.getEmail());
        response.setPhone(student.getPhone());
        response.setDepartment(student.getDepartment());
        response.setYear(student.getYear());
        response.setCgpa(student.getCgpa());
        response.setResumePath(student.getResumePath());
        response.setSkills(student.getSkills());

        return response;
    }
}
