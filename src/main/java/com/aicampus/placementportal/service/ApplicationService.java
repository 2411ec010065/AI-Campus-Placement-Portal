package com.aicampus.placementportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aicampus.placementportal.dto.ApplicationResponse;
import com.aicampus.placementportal.entity.Application;
import com.aicampus.placementportal.repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<ApplicationResponse> getApplications(String studentId) {

        List<Application> applications =
                applicationRepository.findByStudentStudentId(studentId);

        List<ApplicationResponse> response = new ArrayList<>();

        for (Application application : applications) {

            ApplicationResponse dto = new ApplicationResponse();

            dto.setApplicationId(application.getId());
            dto.setCompanyName(
                    application.getPlacementDrive()
                            .getCompany()
                            .getCompanyName());

            dto.setRole(
                    application.getPlacementDrive()
                            .getCompany()
                            .getRole());

            dto.setAppliedDate(
                    application.getAppliedDate().toString());

            dto.setStatus(application.getStatus());

            response.add(dto);
        }

        return response;
    }

}
