package com.example.demo.match;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SkillExtractor {

    private static final Set<String> KNOWN_SKILLS = new HashSet<>(Arrays.asList(
        "java", "spring", "spring boot", "hibernate", "jpa",
        "rest", "api", "jwt", "security",
        "postgresql", "mysql",
        "html", "css", "javascript",
        "git", "maven", "docker"
    ));

    public static Set<String> extractSkills(String text) {

        if (text == null || text.isBlank()) {
            return Set.of(); // return empty skills instead of crashing
        }

        text = text.toLowerCase();

        Set<String> skills = new HashSet<>();

        if (text.contains("java")) skills.add("java");
        if (text.contains("spring")) skills.add("spring");
        if (text.contains("sql")) skills.add("sql");
        if (text.contains("react")) skills.add("react");

        return skills;
    }

    }

