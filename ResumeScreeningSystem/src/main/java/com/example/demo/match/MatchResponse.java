package com.example.demo.match;


import java.util.List;

public class MatchResponse {

    private double matchPercentage;
    private List<String> matchedSkills;
    private List<String> missingSkills;

    public MatchResponse(double matchPercentage,
                         List<String> matchedSkills,
                         List<String> missingSkills) {
        this.matchPercentage = matchPercentage;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
    }

    public double getMatchPercentage() {
        return matchPercentage;
    }

    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }
}
