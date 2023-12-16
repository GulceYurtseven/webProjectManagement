package com.example.demo.request;

public class TaskUpdateRequest {

    private String description;
    private String status;
    private Long projectId;
    // başka güncellenecek şeyler eklenebilşr

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
