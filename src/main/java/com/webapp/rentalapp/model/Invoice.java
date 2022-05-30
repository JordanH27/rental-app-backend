package com.webapp.rentalapp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Invoice implements Serializable {

	private static final long serialVersionUID = 889797071217229383L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	Long invoiceID;
	String date_issued;
	float water_cost;
	float electricity_cost;
	float rent;
	Long propertyTenantID;
	
//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "propertyTenantID")
//	private PropertyTenant propertyTenant;
	 
	@JsonManagedReference
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
	    private Set<PaymentReceived> paymentReceived;

	public Invoice(String date_issued, float water_cost, float electricity_cost, float rent,
			Long propertyTenantID) {
		this.date_issued = date_issued;
		this.water_cost = water_cost;
		this.electricity_cost = electricity_cost;
		this.rent = rent;
		this.propertyTenantID = propertyTenantID;
	}

	public Invoice(Long invoiceID, String date_issued, float water_cost, float electricity_cost, float rent,
			Long propertyTenantID) {
		this.invoiceID = invoiceID;
		this.date_issued = date_issued;
		this.water_cost = water_cost;
		this.electricity_cost = electricity_cost;
		this.rent = rent;
		this.propertyTenantID = propertyTenantID;
	}

	

}
