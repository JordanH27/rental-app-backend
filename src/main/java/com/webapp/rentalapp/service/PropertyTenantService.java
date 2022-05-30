package com.webapp.rentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.rentalapp.exception.UserNotFoundException;
import com.webapp.rentalapp.model.PropertyTenant;
import com.webapp.rentalapp.repository.PropertyTenantRepository;

@Service
@Transactional
public class PropertyTenantService {
	
	private final PropertyTenantRepository propertyTenantRepository;

	@Autowired
	public PropertyTenantService(PropertyTenantRepository propertyTenantRepository) {
		this.propertyTenantRepository = propertyTenantRepository;
	}
	
	public PropertyTenant addPropertyTenant(PropertyTenant propertyTenant) {
		return propertyTenantRepository.save(propertyTenant);
	}
	
	public void deletePropertyTenant(Long id) {
		propertyTenantRepository.deleteById(id);
	}
	
	public PropertyTenant updatePropertyTenant(PropertyTenant propertyTenant) {
		return propertyTenantRepository.save(propertyTenant);
	}
	
	public List<PropertyTenant> findAllPropertyTenants(){
		return propertyTenantRepository.findAll();
	}
	
	public PropertyTenant findPropertyTenantById(Long id) {
		return propertyTenantRepository.findById(id).orElseThrow(() -> new UserNotFoundException ("Property by id " + id + " was not found"));
	}
	
	public void deleteByPropertyAndTenant(Long propertyID, Long tenantID) {
		propertyTenantRepository.deleteByPropertyAndTenant(propertyID, tenantID);
	}
	
}
