package com.webapp.rentalapp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.rentalapp.model.User;
import com.webapp.rentalapp.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User newUser = userService.addUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> user = userService.findAllUser();
		//testing if the user is logged in
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof UserDetails) {
		   email = ((UserDetails)principal).getUsername();
		} else {
		   email = principal.toString();
		}
		System.out.println(email);
		//testing if the user is logged in
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<User> findUser(@PathVariable("id") Long id){
		User user = userService.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public String login(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof UserDetails) {
		   email = ((UserDetails)principal).getUsername();
		} else {
		   email = principal.toString();
		}
		return "Authenitcated successfully as: " + email;
	}
		
}

