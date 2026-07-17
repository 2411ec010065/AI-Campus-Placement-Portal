package com.aicampus.placementportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aicampus.placementportal.dto.PlacementDriveResponse;
import com.aicampus.placementportal.service.PlacementDriveService;

@RestController
@RequestMapping("/placement-drives")
@CrossOrigin(origins = "http://localhost:5173")
public class PlacementDriveController {

    @Autowired
    private PlacementDriveService placementDriveService;

    @GetMapping
    public List<PlacementDriveResponse> getAllPlacementDrives() {

        return placementDriveService.getAllActiveDrives();

    }

}
