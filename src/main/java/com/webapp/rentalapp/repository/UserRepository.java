package com.webapp.rentalapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webapp.rentalapp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email);
	Optional<User> findById(Long id);
}
