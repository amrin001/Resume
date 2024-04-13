package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.WorkExperience;
import com.example.demo.service.WorkExperienceService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class WorkExpController {
	
	@Autowired
	WorkExperienceService workExpService;
	
	// add work experience into DB
	@PostMapping("submitWorkExp")
	public String addWorkExp(Model model, WorkExperience workExp) {
		workExpService.saveEntry(workExp);
		model.addAttribute("Success!");
		return "redirect:addWorkExp";
	}
	
	//goes to the page which shows the list of work experience
	@RequestMapping("resumeMain")
	public String goToResumeMain(Model model, HttpServletRequest request) {
		model.addAttribute("workExperience", workExpService.displayWorkExperience());
		return "resumeMain";
	}
	
	
	

}
