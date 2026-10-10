package com.jobconnect.dto;

public class StatusUpdateRequest {
    private Object status;

    public StatusUpdateRequest() {}

    public String getStatus() { 
        return status != null ? status.toString() : "PENDING"; 
    }
    
    public void setStatus(Object status) { 
        this.status = status; 
    }
}