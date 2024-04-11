package com.example.demo.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	IAdminRepository adminRepository;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	// check if admin account exists
	public boolean checkExistingAdmin() {
		return adminRepository.findById(1).isPresent() ? true : false;
	}

	// create new admin account
	public boolean registerAdminAccount(RegisterNewAdmin registerNewAdmin) {
		System.out.println("Checking matched password " + confirmPassword(registerNewAdmin));
		if (confirmPassword(registerNewAdmin)) {
			adminRepository.save(new Admin (registerNewAdmin.getAdminUsername(), 
					bCryptPasswordEncoder.encode(registerNewAdmin.getAdminPassword()), 
							registerNewAdmin.getFirstName(), registerNewAdmin.getLastName(), 
							registerNewAdmin.getSecurityQuestion(), 
							bCryptPasswordEncoder.encode(registerNewAdmin.getSecurityAnswer())));
			return true;
		}
		return false;
	}


	// check if password and confirm password matches
	public boolean confirmPassword(RegisterNewAdmin registerNewAdmin) {
		return registerNewAdmin.getAdminPassword().equals(registerNewAdmin.getRetypePassword());
	}

	// 
	public boolean loginAdmin(Admin admin) {
		Optional<Admin> temp = adminRepository.findByAdminUsername(admin.getAdminUsername());
		if (temp.isPresent()) {
			Admin foundAdminUser = temp.get();
			return bCryptPasswordEncoder.matches(admin.getAdminPassword(), foundAdminUser.getAdminPassword());
		} 
		return false;
	}

	// display name of user
	public Object displayName() {
		Optional<Admin> temp = adminRepository.findById(1);
		String name = "";
		if (temp.isPresent()) {
			Admin admin = temp.get();
			name = admin.getFirstName()+" "+admin.getLastName();
		}
		return name;
	}

}
