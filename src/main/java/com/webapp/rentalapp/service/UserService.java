package com.webapp.rentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.rentalapp.exception.UserNotFoundException;
import com.webapp.rentalapp.model.User;
import com.webapp.rentalapp.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> findAllUser(){
		return userRepository.findAll();
	}
	
	public User findUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException ("Property by id " + id + " was not found"));
	}
	
}