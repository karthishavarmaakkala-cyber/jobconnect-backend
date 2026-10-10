package com.jobconnect.service;

import com.jobconnect.dto.ApplicationResponse;
import com.jobconnect.model.Application;
import com.jobconnect.model.Job;
import com.jobconnect.model.User;
import com.jobconnect.repository.ApplicationRepository;
import com.jobconnect.repository.JobRepository;
import com.jobconnect.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    public ApplicationService(ApplicationRepository applicationRepository, 
                              JobRepository jobRepository, 
                              UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    public ApplicationResponse applyForJob(Long jobId, Long applicantId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + jobId));
        User applicant = userRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + applicantId));

        Application application = new Application();
        application.setJob(job);
        application.setApplicant(applicant);
        application.setStatus("PENDING");
        application.setAppliedAt(LocalDateTime.now());

        Application savedApplication = applicationRepository.save(application);
        return new ApplicationResponse(savedApplication);
    }

    public List<ApplicationResponse> getApplicationsByApplicant(Long applicantId) {
        return applicationRepository.findByApplicantId(applicantId)
                .stream()
                .map(ApplicationResponse::new)
                .collect(Collectors.toList());
    }

    public List<ApplicationResponse> getApplicationsByApplicantEmail(String email) {
        return applicationRepository.findByApplicantEmail(email)
                .stream()
                .map(ApplicationResponse::new)
                .collect(Collectors.toList());
    }

    public List<ApplicationResponse> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId)
                .stream()
                .map(ApplicationResponse::new)
                .collect(Collectors.toList());
    }

    public List<ApplicationResponse> getApplicationsByRecruiter(Long recruiterId) {
        return applicationRepository.findByJobRecruiterId(recruiterId)
                .stream()
                .map(ApplicationResponse::new)
                .collect(Collectors.toList());
    }

    public ApplicationResponse updateStatus(Long applicationId, String statusStr) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + applicationId));
        
        application.setStatus(statusStr != null ? statusStr.toUpperCase() : "PENDING");

        Application updatedApplication = applicationRepository.save(application);
        return new ApplicationResponse(updatedApplication);
    }
}