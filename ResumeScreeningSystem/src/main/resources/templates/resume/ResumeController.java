package com.example.demo.resume;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping
    public Resume upload(@RequestBody String content,
                          @AuthenticationPrincipal User user) {
        return resumeService.saveResume(user, content);
    }

    @GetMapping
    public List<Resume> myResumes(@AuthenticationPrincipal User user) {
        return resumeService.getUserResumes(user);
    }
}
