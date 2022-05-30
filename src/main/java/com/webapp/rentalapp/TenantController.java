package com.webapp.rentalapp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.rentalapp.model.Tenant;
import com.webapp.rentalapp.service.TenantService;

@RestController
@RequestMapping("/api/tenant")
public class TenantController {
	private final TenantService tenantService;
	
	public TenantController(TenantService tenantService) {
		this.tenantService = tenantService;
	}

	@PostMapping("/add")
	public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant){
		Tenant newTenant = tenantService.addTenant(tenant);
		return new ResponseEntity<>(newTenant, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Tenant> updateTenant(@RequestBody Tenant tenant){
		Tenant updatedTenant = tenantService.updateTenant(tenant);
		return new ResponseEntity<>(updatedTenant, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Tenant>> getAllTenant(){
		List<Tenant> tenant = tenantService.findAllTenants();
		return new ResponseEntity<>(tenant, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
		tenantService.deleteTenant(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Tenant> findUser(@PathVariable("id") Long id){
		Tenant tenant = tenantService.findTenantById(id);
		return new ResponseEntity<>(tenant, HttpStatus.OK);
	}
		
}
