package com.jobconnect.controller;

import com.jobconnect.model.Job;
import com.jobconnect.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @GetMapping
    public List<Job> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();

        // Fallback: If DB is empty, return initial 5 jobs directly
        if (jobs.isEmpty()) {
            jobs = new ArrayList<>();

            Job j1 = new Job();
            j1.setId(1L);
            j1.setTitle("Java Backend Developer");
            j1.setDescription("Looking for a skilled Java Developer with Spring Boot experience.");
            j1.setCompany("Tech Corp");
            j1.setCompanyName("Tech Corp");
            j1.setLocation("Hyderabad");
            j1.setSalary("₹12,00,000 / year (12 LPA)");
            j1.setSkills("Java, Spring Boot, MySQL, REST API");
            j1.setPostedBy("recruiter@jobconnect.com");
            jobs.add(j1);

            Job j2 = new Job();
            j2.setId(2L);
            j2.setTitle("Frontend React Developer");
            j2.setDescription("Looking for a skilled React Developer to build dynamic interfaces.");
            j2.setCompany("WebWorks Inc");
            j2.setCompanyName("WebWorks Inc");
            j2.setLocation("Remote");
            j2.setSalary("₹10,50,000 / year (10.5 LPA)");
            j2.setSkills("React, JavaScript, CSS3, HTML5");
            j2.setPostedBy("recruiter@jobconnect.com");
            jobs.add(j2);

            Job j3 = new Job();
            j3.setId(3L);
            j3.setTitle("Full Stack Engineer");
            j3.setDescription("Looking for Node.js, Spring Boot, and React expertise.");
            j3.setCompany("CloudTech");
            j3.setCompanyName("CloudTech");
            j3.setLocation("Bangalore");
            j3.setSalary("₹15,00,000 / year (15 LPA)");
            j3.setSkills("Node.js, React, Java, MongoDB");
            j3.setPostedBy("recruiter@jobconnect.com");
            jobs.add(j3);

            Job j4 = new Job();
            j4.setId(4L);
            j4.setTitle("DevOps Engineer");
            j4.setDescription("Automate CI/CD pipelines and manage AWS cloud infrastructure.");
            j4.setCompany("DataScale");
            j4.setCompanyName("DataScale");
            j4.setLocation("Remote");
            j4.setSalary("₹18,00,000 / year (18 LPA)");
            j4.setSkills("Docker, Kubernetes, AWS, Jenkins");
            j4.setPostedBy("recruiter@jobconnect.com");
            jobs.add(j4);

            Job j5 = new Job();
            j5.setId(5L);
            j5.setTitle("UI/UX Designer");
            j5.setDescription("Design modern interfaces for web and mobile applications.");
            j5.setCompany("DesignHub");
            j5.setCompanyName("DesignHub");
            j5.setLocation("Mumbai");
            j5.setSalary("₹9,00,000 / year (9 LPA)");
            j5.setSkills("Figma, Adobe XD, CSS");
            j5.setPostedBy("recruiter@jobconnect.com");
            jobs.add(j5);
        }

        return jobs;
    }
}