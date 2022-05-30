package com.webapp.rentalapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class InvoiceDetails {
	Long invoiceID;
	float electricity_cost;
	float rent;
	float water_cost;
	String addressLine1;
	String firstName;
	String lastName;
}
