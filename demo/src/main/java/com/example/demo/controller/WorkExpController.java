package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.WorkExperience;
import com.example.demo.service.WorkExperienceService;

@Controller
public class WorkExpController {
	
	@Autowired
	WorkExperienceService workExpService;
	
	@PostMapping("submitWorkExp")
	public String addWorkExp(Model model, WorkExperience workExp) {
		workExpService.saveEntry(workExp);
		model.addAttribute("Success!");
		return "addWorkExp";
	}

}
