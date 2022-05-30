package com.webapp.rentalapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User implements Serializable{
	
	private static final long serialVersionUID = 4614470526639485694L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable=false)
	Long userID;	
	String firstName;
	String lastName;
	String password;
	String contactNo;
	String email;
	String role;
	
	public User(Long userID, String firstName, String lastName, String password, String contactNo, String email, String role) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.email = email;
		this.role = role;
	}

	
	public User(String firstName, String lastName, String password, String contactNo, String email, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.email = email;
		this.role = role;
	}
	
	
}
