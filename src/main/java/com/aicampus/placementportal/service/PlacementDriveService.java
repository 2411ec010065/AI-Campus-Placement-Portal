package com.aicampus.placementportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aicampus.placementportal.dto.PlacementDriveResponse;
import com.aicampus.placementportal.entity.PlacementDrive;
import com.aicampus.placementportal.repository.PlacementDriveRepository;

@Service
public class PlacementDriveService {

    @Autowired
    private PlacementDriveRepository placementDriveRepository;

    public List<PlacementDriveResponse> getAllActiveDrives() {

        List<PlacementDrive> drives = placementDriveRepository.findByActiveTrue();

        List<PlacementDriveResponse> response = new ArrayList<>();

        for (PlacementDrive drive : drives) {

            PlacementDriveResponse dto = new PlacementDriveResponse();

            dto.setDriveId(drive.getId());
            dto.setCompanyName(drive.getCompany().getCompanyName());
            dto.setRole(drive.getCompany().getRole());
            dto.setPackageLpa(drive.getCompany().getPackageLpa());
            dto.setMinCgpa(drive.getCompany().getMinCgpa());
            dto.setRequiredSkills(drive.getCompany().getRequiredSkills());
            dto.setDriveDate(drive.getDriveDate().toString());
            dto.setLocation(drive.getLocation());
            dto.setActive(drive.getActive());

            response.add(dto);
        }

        return response;
    }
}