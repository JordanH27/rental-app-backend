package com.webapp.rentalapp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PaymentReceived implements Serializable {

	private static final long serialVersionUID = -8225250269516207814L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	Long paymentID;
	float amountReceived;
	String date;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invoiceID")
    private Invoice invoice;

	public PaymentReceived(float amountReceived, String date, Invoice invoice) {
		super();
		this.amountReceived = amountReceived;
		this.date = date;
		this.invoice = invoice;
	}

	public PaymentReceived(Long paymentID, float amountReceived, String date, Invoice invoice) {
		super();
		this.paymentID = paymentID;
		this.amountReceived = amountReceived;
		this.date = date;
		this.invoice = invoice;
	}
	
	
}
