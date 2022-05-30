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

import com.webapp.rentalapp.model.Property;
import com.webapp.rentalapp.service.PropertyService;

@RestController
@RequestMapping("/api/property")
public class PropertyController {
	private final PropertyService propertyService;
	
	public PropertyController(PropertyService propertyService) {
		this.propertyService = propertyService;
	}

	@PostMapping("/add")
	public ResponseEntity<Property> addProperty(@RequestBody Property property){
		Property newProperty = propertyService.addProperty(property);
		return new ResponseEntity<>(newProperty, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Property> updateProperty(@RequestBody Property property){
		Property updatedProperty = propertyService.updateProperty(property);
		return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Property>> getAllProperty(){
		List<Property> property = propertyService.findAllProperty();
		return new ResponseEntity<>(property, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProperty(@PathVariable("id") Long id){
		propertyService.deleteProperty(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Property> findProperty(@PathVariable("id") Long id){
		Property property = propertyService.findPropertyById(id);
		return new ResponseEntity<>(property, HttpStatus.OK);
	}
		
}
