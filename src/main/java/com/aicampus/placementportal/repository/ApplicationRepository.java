package com.aicampus.placementportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aicampus.placementportal.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByStudentStudentId(String studentId);

}
