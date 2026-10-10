package com.jobconnect.dto;

import com.jobconnect.model.Application;
import com.jobconnect.model.Job;
import com.jobconnect.model.User;

import java.time.LocalDateTime;

public class ApplicationResponse {

    private Long id;
    private Long jobId;
    private String jobTitle;
    private String companyName;
    private Long applicantId;
    private String applicantName;
    private String applicantEmail;
    private String status;
    private LocalDateTime appliedAt;

    public ApplicationResponse() {}

    public ApplicationResponse(Application application) {
        if (application != null) {
            this.id = application.getId();
            this.status = application.getStatus() != null ? application.getStatus().toString() : "PENDING";
            this.appliedAt = application.getAppliedAt();
            
            Job job = application.getJob();
            if (job != null) {
                this.jobId = job.getId();
                this.jobTitle = job.getTitle();
                this.companyName = job.getCompany();
            }

            User applicant = application.getApplicant();
            if (applicant != null) {
                this.applicantId = applicant.getId();
                this.applicantName = applicant.getFullName();
                this.applicantEmail = applicant.getEmail();
            }
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public Long getApplicantId() { return applicantId; }
    public void setApplicantId(Long applicantId) { this.applicantId = applicantId; }

    public String getApplicantName() { return applicantName; }
    public void setApplicantName(String applicantName) { this.applicantName = applicantName; }

    public String getApplicantEmail() { return applicantEmail; }
    public void setApplicantEmail(String applicantEmail) { this.applicantEmail = applicantEmail; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getAppliedAt() { return appliedAt; }
    public void setAppliedAt(LocalDateTime appliedAt) { this.appliedAt = appliedAt; }
}