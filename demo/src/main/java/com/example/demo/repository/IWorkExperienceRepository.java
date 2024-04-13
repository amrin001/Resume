package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.example.demo.model.WorkExperience;

public interface IWorkExperienceRepository extends JpaRepository<WorkExperience, Integer>{
	
	@Query("SELECT companyName FROM WorkExperience")
	List<WorkExperience> listCompanies();
	
	@Query("SELECT positionTitle FROM WorkExperience")
	List<WorkExperience> listPosition();
	
	@Query("SELECT startDate FROM WorkExperience")
	List<WorkExperience> listStartDate();
	
	@Query("SELECT endDate FROM WorkExperience")
	List<WorkExperience> listEndDate();
	
	@Query("SELECT description FROM WorkExperience")
	List<WorkExperience> listDescription();

}
