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
public class Property implements Serializable {

	private static final long serialVersionUID = -8225250269516207814L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	Long propertyID;
	String addressLine1;
	String addressLine2;
	String province;
	String suburb;
	boolean water_prepaid;
	boolean electricity_prepaid;
	float rent;
	String type;

//    @JsonManagedReference
//	@OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
//	private Set<PropertyTenant> propertyTenant;

	public Property(String addressLine1, String addressLine2, String province, String suburb, boolean water_prepaid,
			boolean electricity_prepaid, float rent, String type) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.province = province;
		this.suburb = suburb;
		this.water_prepaid = water_prepaid;
		this.electricity_prepaid = electricity_prepaid;
		this.rent = rent;
		this.type = type;
	}

	public Property(Long propertyID, String addressLine1, String addressLine2, String province, String suburb,
			boolean water_prepaid, boolean electricity_prepaid, float rent, String type) {
		super();
		this.propertyID = propertyID;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.province = province;
		this.suburb = suburb;
		this.water_prepaid = water_prepaid;
		this.electricity_prepaid = electricity_prepaid;
		this.rent = rent;
		this.type = type;
	}

	public Property(String addressLine1, String province, String suburb, boolean water_prepaid,
			boolean electricity_prepaid, float rent, String type) {
		super();
		this.addressLine1 = addressLine1;
		this.province = province;
		this.suburb = suburb;
		this.water_prepaid = water_prepaid;
		this.electricity_prepaid = electricity_prepaid;
		this.rent = rent;
		this.type = type;
	}

	public Property(Long propertyID, String addressLine1, String province, String suburb, boolean water_prepaid,
			boolean electricity_prepaid, float rent, String type) {
		super();
		this.propertyID = propertyID;
		this.addressLine1 = addressLine1;
		this.province = province;
		this.suburb = suburb;
		this.water_prepaid = water_prepaid;
		this.electricity_prepaid = electricity_prepaid;
		this.rent = rent;
		this.type = type;
	}
}
