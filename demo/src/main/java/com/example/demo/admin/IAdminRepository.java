package com.example.demo.admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	
	Optional<Admin> findByAdminUsername(String adminUsername);
	
	Admin getByAdminUsername(String string);

}
