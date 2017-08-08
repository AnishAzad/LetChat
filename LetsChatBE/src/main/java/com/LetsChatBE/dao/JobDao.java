package com.LetsChatBE.dao;

import java.util.List;

import com.LetsChatBE.model.Job;

public interface JobDao {
	void saveJob(Job job);
	List<Job> getAllJobs();
	Job getJobById(int id);
}
