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
public class Tenant implements Serializable {

	private static final long serialVersionUID = -7588498362136564950L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	Long tenantID;
	String firstName;
	String lastName;
	String contactNo;
	String dob;
	String email;

//	@JsonManagedReference
//	@OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
//	private Set<PropertyTenant> propertyTenant;
	
	public Tenant(String firstName, String lastName, String contactNo, String dob, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.dob = dob;
		this.email = email;
	}

	public Tenant(Long tenantID, String firstName, String lastName, String contactNo, String dob, String email) {
		this.tenantID = tenantID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.dob = dob;
		this.email = email;
	}

	
}
