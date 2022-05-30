package com.webapp.rentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.rentalapp.model.PaymentReceived;
import com.webapp.rentalapp.repository.PaymentReceivedRepository;

@Service
@Transactional
public class PaymentReceivedService {
	
	private final PaymentReceivedRepository paymentReceivedRepository;

	@Autowired
	public PaymentReceivedService(PaymentReceivedRepository paymentReceivedRepository) {
		this.paymentReceivedRepository = paymentReceivedRepository;
	}
	
	public PaymentReceived addPaymentReceived(PaymentReceived paymentReceived) {
		return paymentReceivedRepository.save(paymentReceived);
	}
	
	public void deletePaymentReceived(Long id) {
		paymentReceivedRepository.deleteById(id);
	}
	
	public PaymentReceived updatePaymentReceived(PaymentReceived paymentReceived) {
		return paymentReceivedRepository.save(paymentReceived);
	}
	
	public List<PaymentReceived> findAllPaymentReceived(){
		return paymentReceivedRepository.findAll();
	}
	
	public PaymentReceived findPaymentReceivedById(Long id) {
		return paymentReceivedRepository.getById(id);
	}
	
}
