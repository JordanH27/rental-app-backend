package com.webapp.rentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.rentalapp.exception.UserNotFoundException;
import com.webapp.rentalapp.model.Property;
import com.webapp.rentalapp.repository.PropertyRepository;

@Service
@Transactional
public class PropertyService {
	
	private final PropertyRepository propertyRepository;

	@Autowired
	public PropertyService(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
	}
	
	public Property addProperty(Property property) {
		return propertyRepository.save(property);
	}
	
	public void deleteProperty(Long id) {
		propertyRepository.deleteById(id);
	}
	
	public Property updateProperty(Property property) {
		return propertyRepository.save(property);
	}
	
	public List<Property> findAllProperty(){
		return propertyRepository.findAll();
	}
	
	public Property findPropertyById(Long id) {
		return propertyRepository.findById(id).orElseThrow(() -> new UserNotFoundException ("Property by id " + id + " was not found"));
	}
	
}
