package com.webapp.rentalapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.rentalapp.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{
	Optional<Property> findById(Long id);
}
