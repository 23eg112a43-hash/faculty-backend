package com.faculty.leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.faculty.leave.entity.LeaveRequest;

public interface LeaveRepository extends JpaRepository<LeaveRequest, Long> {
}