package com.aicampus.placementportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aicampus.placementportal.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
