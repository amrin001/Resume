package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.WorkExperience;
import com.example.demo.repository.IWorkExperienceRepository;

@Service
public class WorkExperienceService {

	@Autowired
	IWorkExperienceRepository workExperienceRepository;

	// save cv detail entry
	public boolean saveEntry(WorkExperience cvDetails) {
		workExperienceRepository.save(new WorkExperience(cvDetails.getCompanyName(), cvDetails.getPositionTitle(),
				cvDetails.getStartDate(), cvDetails.getEndDate(), cvDetails.getDescription()));
		return true;
	}
	
	

}
