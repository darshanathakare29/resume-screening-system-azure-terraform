package com.example.demo.resume;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.User;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    public Resume saveResume(User user, String content) {
        Resume resume = new Resume();
        resume.setUser(user);
        resume.setContent(content);
        return resumeRepository.save(resume);
    }

    public List<Resume> getUserResumes(User user) {
        return resumeRepository.findByUser(user);
    }

}

