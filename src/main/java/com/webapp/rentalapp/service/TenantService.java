package com.webapp.rentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.rentalapp.exception.UserNotFoundException;
import com.webapp.rentalapp.model.Tenant;
import com.webapp.rentalapp.repository.TenantRepository;

@Service
@Transactional
public class TenantService {
	
	private final TenantRepository tenantRepository;

	@Autowired
	public TenantService(TenantRepository tenantRepository) {
		this.tenantRepository = tenantRepository;
	}
	
	public Tenant addTenant(Tenant tenant) {
		return tenantRepository.save(tenant);
	}
	
	public void deleteTenant(Long id) {
		tenantRepository.deleteById(id);
	}
	
	public Tenant updateTenant(Tenant tenant) {
		return tenantRepository.save(tenant);
	}
	
	public List<Tenant> findAllTenants(){
		return tenantRepository.findAll();
	}
	
	public Tenant findTenantById(Long id) {
		return tenantRepository.findById(id).orElseThrow(() -> new UserNotFoundException ("Property by id " + id + " was not found"));
	}
	
}
