package com.aicampus.placementportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aicampus.placementportal.dto.DashboardResponse;
import com.aicampus.placementportal.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/{studentId}")
    public DashboardResponse getDashboard(@PathVariable String studentId) {

        return dashboardService.getDashboard(studentId);
    }
}