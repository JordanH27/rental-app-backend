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

import com.webapp.rentalapp.model.PropertyTenant;
import com.webapp.rentalapp.service.PropertyTenantService;

@RestController
@RequestMapping("/api/propertyTenant")
public class PropertyTenantController {
	private final PropertyTenantService propertyTenantService;
	
	public PropertyTenantController(PropertyTenantService propertyTenantService) {
		this.propertyTenantService = propertyTenantService;
	}

	@PostMapping("/add")
	public ResponseEntity<PropertyTenant> addPropertyTenant(@RequestBody PropertyTenant propertyTenant){
		PropertyTenant newPropertyTenant = propertyTenantService.addPropertyTenant(propertyTenant);
		return new ResponseEntity<>(newPropertyTenant, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<PropertyTenant> updatePropertyTenant(@RequestBody PropertyTenant propertyTenant){
		PropertyTenant updatedPropertyTenant = propertyTenantService.updatePropertyTenant(propertyTenant);
		return new ResponseEntity<>(updatedPropertyTenant, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PropertyTenant>> getAllPropertyTenant(){
		List<PropertyTenant> propertyTenant = propertyTenantService.findAllPropertyTenants();
		return new ResponseEntity<>(propertyTenant, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePropertyTenant(@PathVariable("id") Long id){
		propertyTenantService.deletePropertyTenant(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/property/{propertyID}/tenant/{tenantID}")
	public ResponseEntity<?> deletePropertyTenant(@PathVariable("propertyID") Long propertyID, @PathVariable("tenantID") Long tenantID){
		propertyTenantService.deleteByPropertyAndTenant(propertyID, tenantID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<PropertyTenant> findPropertyTenant(@PathVariable("id") Long id){
		PropertyTenant propertyTenant = propertyTenantService.findPropertyTenantById(id);
		return new ResponseEntity<>(propertyTenant, HttpStatus.OK);
	}
		
}
