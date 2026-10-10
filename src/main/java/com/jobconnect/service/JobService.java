package com.jobconnect.service;

import com.jobconnect.dto.JobRequest;
import com.jobconnect.model.Job;
import com.jobconnect.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> searchJobs(String keyword) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            return jobRepository.findByTitleContainingIgnoreCaseOrLocationContainingIgnoreCase(keyword, keyword);
        }
        return jobRepository.findAll();
    }

    public Job createJob(JobRequest request, String postedBy) {
        Job job = new Job();
        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setCompany(request.getCompany());
        job.setLocation(request.getLocation());
        job.setSalary(request.getSalary());
        job.setPostedBy(postedBy);
        return jobRepository.save(job);
    }
}