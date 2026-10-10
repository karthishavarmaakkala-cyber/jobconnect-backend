package com.jobconnect.controller;

import com.jobconnect.dto.ApplicationRequest;
import com.jobconnect.dto.ApplicationResponse;
import com.jobconnect.dto.StatusUpdateRequest;
import com.jobconnect.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs/applications")
@CrossOrigin(origins = "http://localhost:3000")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<ApplicationResponse> applyForJob(@RequestBody ApplicationRequest request) {
        ApplicationResponse response = applicationService.applyForJob(request.getJobId(), request.getApplicantId());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    public ResponseEntity<List<ApplicationResponse>> getMyApplications(@RequestParam(required = false) Long applicantId,
                                                                        @RequestParam(required = false) String email) {
        if (applicantId != null) {
            return ResponseEntity.ok(applicationService.getApplicationsByApplicant(applicantId));
        } else if (email != null && !email.trim().isEmpty()) {
            return ResponseEntity.ok(applicationService.getApplicationsByApplicantEmail(email));
        }
        return ResponseEntity.ok(List.of());
    }

    @GetMapping("/recruiter")
    public ResponseEntity<List<ApplicationResponse>> getRecruiterApplications(@RequestParam Long recruiterId) {
        return ResponseEntity.ok(applicationService.getApplicationsByRecruiter(recruiterId));
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationResponse>> getApplicationsForJob(@PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.getApplicationsByJobId(jobId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationResponse> updateStatus(@PathVariable Long id, 
                                                            @RequestBody StatusUpdateRequest request) {
        ApplicationResponse response = applicationService.updateStatus(id, request.getStatus());
        return ResponseEntity.ok(response);
    }
}