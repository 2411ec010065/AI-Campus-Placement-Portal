package com.aicampus.placementportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aicampus.placementportal.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}