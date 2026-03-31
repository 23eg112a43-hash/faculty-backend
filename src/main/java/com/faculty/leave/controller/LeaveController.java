package com.faculty.leave.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.faculty.leave.entity.LeaveRequest;
import com.faculty.leave.entity.User;
import com.faculty.leave.repository.LeaveRepository;
import com.faculty.leave.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/leave")
public class LeaveController {

    private final LeaveRepository leaveRepository;
    private final UserRepository userRepository;

    public LeaveController(LeaveRepository leaveRepository, UserRepository userRepository) {
        this.leaveRepository = leaveRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/apply/{userId}")
    public LeaveRequest applyLeave(@PathVariable Long userId,
                                  @RequestBody LeaveRequest leave) {

        User user = userRepository.findById(userId).orElseThrow();
        leave.setFaculty(user);
        leave.setStatus("PENDING");

        return leaveRepository.save(leave);
    }

    @GetMapping("/all")
    public List<LeaveRequest> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @PutMapping("/approve/{id}")
    public LeaveRequest approve(@PathVariable Long id) {
        LeaveRequest leave = leaveRepository.findById(id).orElseThrow();
        leave.setStatus("APPROVED");
        return leaveRepository.save(leave);
    }

    @PutMapping("/reject/{id}")
    public LeaveRequest reject(@PathVariable Long id) {
        LeaveRequest leave = leaveRepository.findById(id).orElseThrow();
        leave.setStatus("REJECTED");
        return leaveRepository.save(leave);
    }
}