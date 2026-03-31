package com.faculty.leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.faculty.leave.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}