package com.faculty.leave.entity;

import jakarta.persistence.*;

@Entity
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String leaveType;
    private String startDate;
    private String endDate;
    private String reason;
    private String status;

    @ManyToOne
    private User faculty;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getLeaveType() { return leaveType; }

    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }

    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public String getReason() { return reason; }

    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public User getFaculty() { return faculty; }

    public void setFaculty(User faculty) { this.faculty = faculty; }
}