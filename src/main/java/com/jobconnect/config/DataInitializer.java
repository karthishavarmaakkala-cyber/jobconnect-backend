package com.jobconnect.config;

import com.jobconnect.model.Job;
import com.jobconnect.model.Role;
import com.jobconnect.model.User;
import com.jobconnect.repository.JobRepository;
import com.jobconnect.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(JobRepository jobRepository, UserRepository userRepository) {
        return args -> {
            try {
                // 1. Seed Default Users
                if (userRepository.count() == 0) {
                    Role applicantRole = Role.values()[0];
                    Role recruiterRole = Role.values().length > 1 ? Role.values()[1] : applicantRole;

                    User applicant = new User();
                    applicant.setEmail("user@jobconnect.com");
                    applicant.setPassword("123456");
                    applicant.setRole(applicantRole);
                    userRepository.save(applicant);

                    User recruiter = new User();
                    recruiter.setEmail("recruiter@jobconnect.com");
                    recruiter.setPassword("123456");
                    recruiter.setRole(recruiterRole);
                    userRepository.save(recruiter);

                    System.out.println("--> Seeded default users: user@jobconnect.com / recruiter@jobconnect.com");
                }

                // 2. Seed Jobs (Salaries in INR / LPA)
                if (jobRepository.count() == 0) {
                    Job j1 = new Job();
                    j1.setTitle("Java Backend Developer");
                    j1.setDescription("Looking for a skilled Java Developer with Spring Boot experience.");
                    j1.setCompany("Tech Corp");
                    j1.setCompanyName("Tech Corp");
                    j1.setLocation("Hyderabad");
                    j1.setSalary("₹12,00,000 / year (12 LPA)");
                    j1.setSkills("Java, Spring Boot, MySQL, REST API");
                    j1.setPostedBy("recruiter@jobconnect.com");
                    j1.setRecruiterId(1L);

                    Job j2 = new Job();
                    j2.setTitle("Frontend React Developer");
                    j2.setDescription("Looking for a skilled React Developer to build dynamic interfaces.");
                    j2.setCompany("WebWorks Inc");
                    j2.setCompanyName("WebWorks Inc");
                    j2.setLocation("Remote");
                    j2.setSalary("₹10,50,000 / year (10.5 LPA)");
                    j2.setSkills("React, JavaScript, CSS3, HTML5");
                    j2.setPostedBy("recruiter@jobconnect.com");
                    j2.setRecruiterId(1L);

                    Job j3 = new Job();
                    j3.setTitle("Full Stack Engineer");
                    j3.setDescription("Looking for Node.js, Spring Boot, and React expertise.");
                    j3.setCompany("CloudTech");
                    j3.setCompanyName("CloudTech");
                    j3.setLocation("Bangalore");
                    j3.setSalary("₹15,00,000 / year (15 LPA)");
                    j3.setSkills("Node.js, React, Java, MongoDB");
                    j3.setPostedBy("recruiter@jobconnect.com");
                    j3.setRecruiterId(1L);

                    Job j4 = new Job();
                    j4.setTitle("DevOps Engineer");
                    j4.setDescription("Automate CI/CD pipelines and manage AWS cloud infrastructure.");
                    j4.setCompany("DataScale");
                    j4.setCompanyName("DataScale");
                    j4.setLocation("Remote");
                    j4.setSalary("₹18,00,000 / year (18 LPA)");
                    j4.setSkills("Docker, Kubernetes, AWS, Jenkins");
                    j4.setPostedBy("recruiter@jobconnect.com");
                    j4.setRecruiterId(1L);

                    Job j5 = new Job();
                    j5.setTitle("UI/UX Designer");
                    j5.setDescription("Design modern interfaces for web and mobile applications.");
                    j5.setCompany("DesignHub");
                    j5.setCompanyName("DesignHub");
                    j5.setLocation("Mumbai");
                    j5.setSalary("₹9,00,000 / year (9 LPA)");
                    j5.setSkills("Figma, Adobe XD, CSS");
                    j5.setPostedBy("recruiter@jobconnect.com");
                    j5.setRecruiterId(1L);

                    jobRepository.save(j1);
                    jobRepository.save(j2);
                    jobRepository.save(j3);
                    jobRepository.save(j4);
                    jobRepository.save(j5);

                    System.out.println("--> Seeded 5 job listings successfully!");
                }
            } catch (Exception e) {
                System.err.println("Warning: Data initialization skipped due to: " + e.getMessage());
            }
        };
    }
}