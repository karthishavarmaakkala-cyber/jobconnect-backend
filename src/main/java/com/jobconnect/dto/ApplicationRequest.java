package com.jobconnect.dto;

public class ApplicationRequest {
    private Long jobId;
    private Long applicantId;
    private Long userId;

    public ApplicationRequest() {}

    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }

    public Long getApplicantId() { 
        return applicantId != null ? applicantId : userId; 
    }
    public void setApplicantId(Long applicantId) { this.applicantId = applicantId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}