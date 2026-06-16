package com.example.demo.resume;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.user.User;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    List<Resume> findByUser(User user);
}
