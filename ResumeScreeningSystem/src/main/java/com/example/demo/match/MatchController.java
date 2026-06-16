package com.example.demo.match;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/resume/{resumeId}/job/{jobId}")
    public MatchResponse match(
            @PathVariable Long resumeId,
            @PathVariable Long jobId) {

        return matchService.match(resumeId, jobId);
    }
}
