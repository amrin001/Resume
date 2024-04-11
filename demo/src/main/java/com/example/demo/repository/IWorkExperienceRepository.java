package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.WorkExperience;

public interface IWorkExperienceRepository extends JpaRepository<WorkExperience, Integer>{

}
