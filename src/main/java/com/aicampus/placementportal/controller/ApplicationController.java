package com.aicampus.placementportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aicampus.placementportal.dto.ApplicationResponse;
import com.aicampus.placementportal.service.ApplicationService;

@RestController
@RequestMapping("/applications")
@CrossOrigin(origins = "http://localhost:5173")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/{studentId}")
    public List<ApplicationResponse> getApplications(
            @PathVariable String studentId) {

        return applicationService.getApplications(studentId);
    }

}
