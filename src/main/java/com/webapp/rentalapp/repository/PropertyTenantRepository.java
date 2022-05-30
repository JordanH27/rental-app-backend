package com.webapp.rentalapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.rentalapp.model.PropertyTenant;

public interface PropertyTenantRepository extends JpaRepository<PropertyTenant, Long>{
	Optional<PropertyTenant> findById(Long id);
	
	@Modifying
	@Query("delete from PropertyTenant p where p.propertyID=:propertyID AND p.tenantID=:tenantID")
	void deleteByPropertyAndTenant(@Param("propertyID")Long propertyID, @Param("tenantID")Long tenantID);
}
