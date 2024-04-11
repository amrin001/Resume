package com.example.demo.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterNewAdmin {
	
	private String adminUsername;
	private String firstName;
	private String lastName;
	private String adminPassword;
	private String retypePassword;
	private String securityQuestion;
	private String securityAnswer;

}
