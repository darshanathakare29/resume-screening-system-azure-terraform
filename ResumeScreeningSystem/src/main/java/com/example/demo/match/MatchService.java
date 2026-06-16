package com.example.demo.match;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.job.Job;
import com.example.demo.job.JobRepository;
import com.example.demo.resume.Resume;
import com.example.demo.resume.ResumeRepository;

@Service
public class MatchService {

    private final ResumeRepository resumeRepository;
    private final JobRepository jobRepository;

    public MatchService(ResumeRepository resumeRepository,
                        JobRepository jobRepository) {
        this.resumeRepository = resumeRepository;
        this.jobRepository = jobRepository;
    }

    public MatchResponse match(Long resumeId, Long jobId) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        // ✅ Defensive initialization
        Set<String> resumeSkills = new HashSet<>();
        Set<String> jobSkills = new HashSet<>();

        if (resume.getContent() != null && !resume.getContent().isBlank()) {
            resumeSkills = SkillExtractor.extractSkills(resume.getContent());
        }

        if (job.getDescription() != null && !job.getDescription().isBlank()) {
            jobSkills = SkillExtractor.extractSkills(job.getDescription());
        }

        List<String> matched = new ArrayList<>();
        List<String> missing = new ArrayList<>();

        for (String skill : jobSkills) {
            if (resumeSkills.contains(skill)) {
                matched.add(skill);
            } else {
                missing.add(skill);
            }
        }

        double score = jobSkills.isEmpty()
                ? 0
                : ((double) matched.size() / jobSkills.size()) * 100;

        return new MatchResponse(score, matched, missing);
    }
}
