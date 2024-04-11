package com.example.demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller

public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	
	
	@RequestMapping("admin")
	public String goToAdminLogin() {
		System.out.println("Checking Existing admin account: " + adminService.checkExistingAdmin());
		if (adminService.checkExistingAdmin()==false) {
			System.out.println("The outcome is: " + adminService.checkExistingAdmin());
			return "redirect:createAdminAccount";
		}
		return "admin";
	}
	
	@RequestMapping("createAdminAccount")
	public String goToCreateAdminAccount() {
		return "createAdminAccount";
	}
	
	@PostMapping("creatingAdminAccount")
	public String registeringNewAdmin(RegisterNewAdmin registerNewAdmin, Model model) {
		if (adminService.registerAdminAccount(registerNewAdmin)) {				
			return "admin";
		} else {
			model.addAttribute("errorMessage", "Password mismatch!");
			return "createAdminAccount";
		}
	}

	@RequestMapping("adminLogin")
	public String adminLogin(Admin admin, HttpServletRequest request, Model model) {
		if (adminService.loginAdmin(admin)) {
			System.out.println("The outcome is: "+adminService.checkExistingAdmin());
			request.getSession().setAttribute("adminLogin", admin.getAdminUsername());
			request.getSession().setAttribute("adminName", adminService.displayName());
			System.out.println(request.getSession().getAttribute("adminLogin"));
			return "redirect:adminHome"; 
		} else {
			model.addAttribute("errorMessage", "Invalid credentials!");
			return "admin";
		}
	}
	
	@RequestMapping("adminHome")
	public String goToAdminHome(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("adminLogin")==null) {
			return "redirect:admin";
		}
		System.out.println(request.getSession().getAttribute("adminName"));
		model.addAttribute("name", request.getSession().getAttribute("adminName"));
		return "adminHome";
	}
	
	
	/**
	 * 
	 * Goes to WorkExperienceController
	 * Only navigates to page
	 * 
	 */
	@RequestMapping("addWorkExp")
	public String goToAddWorkExp() {
		return "addWorkExp";
	}

}
