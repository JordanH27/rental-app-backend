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

import com.webapp.rentalapp.model.PaymentReceived;
import com.webapp.rentalapp.service.PaymentReceivedService;

@RestController
@RequestMapping("/api/payment")
public class PaymentReceivedController {
	private final PaymentReceivedService paymentReceivedService;
	
	public PaymentReceivedController(PaymentReceivedService paymentReceivedService) {
		this.paymentReceivedService = paymentReceivedService;
	}

	@PostMapping("/add")
	public ResponseEntity<PaymentReceived> addPaymentReceived(@RequestBody PaymentReceived paymentReceived){
		PaymentReceived newPaymentReceived = paymentReceivedService.addPaymentReceived(paymentReceived);
		return new ResponseEntity<>(newPaymentReceived, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<PaymentReceived> updatePaymentReceived(@RequestBody PaymentReceived paymentReceived){
		PaymentReceived updatedPaymentReceived = paymentReceivedService.updatePaymentReceived(paymentReceived);
		return new ResponseEntity<>(updatedPaymentReceived, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PaymentReceived>> getAllPaymentReceived(){
		List<PaymentReceived> paymentReceived = paymentReceivedService.findAllPaymentReceived();
		return new ResponseEntity<>(paymentReceived, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePaymentReceived(@PathVariable("id") Long id){
		paymentReceivedService.deletePaymentReceived(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<PaymentReceived> findPaymentReceived(@PathVariable("id") Long id){
		PaymentReceived paymentReceived = paymentReceivedService.findPaymentReceivedById(id);
		return new ResponseEntity<>(paymentReceived, HttpStatus.OK);
	}
		
}
