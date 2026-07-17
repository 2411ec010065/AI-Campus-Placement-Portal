package com.aicampus.placementportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aicampus.placementportal.entity.PlacementDrive;

public interface PlacementDriveRepository extends JpaRepository<PlacementDrive, Long> {

    List<PlacementDrive> findByActiveTrue();

}