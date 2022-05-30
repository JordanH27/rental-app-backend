package com.webapp.rentalapp.repository;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.rentalapp.model.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long>{
	Optional<Tenant> findById(Long id);
}
