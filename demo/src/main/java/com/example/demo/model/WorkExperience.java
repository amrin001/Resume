package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table
public class WorkExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String companyName;
	private String positionTitle;
	private String startDate;
	private String endDate;
	private String description;
	
	public WorkExperience(String companyName, String positionTitle, String startDate, String endDate, String description) {
		this.companyName = companyName;
		this.positionTitle = positionTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}
	
	public WorkExperience(String companyName, String positionTitle, String startDate, String description) {
		this.companyName = companyName;
		this.positionTitle = positionTitle;
		this.startDate = startDate;
		this.description = description;
	}

}
