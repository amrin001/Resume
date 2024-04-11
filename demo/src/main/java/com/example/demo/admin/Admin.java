package com.example.demo.admin;


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
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id = 1;
	private String adminUsername;
	private String adminPassword;
	private String firstName;
	private String lastName;
	private String securityQuestion;
	private String securityAnswer;
	
	
	public Admin(String adminUsername, String adminPassword, String firstName, String lastName,
			String securityQuestion, String securityAnswer) {
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	
	

}
