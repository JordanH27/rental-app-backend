package com.webapp.rentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.rentalapp.exception.UserNotFoundException;
import com.webapp.rentalapp.model.Invoice;
import com.webapp.rentalapp.repository.InvoiceRepository;

@Service
@Transactional
public class InvoiceService {
	
	private final InvoiceRepository invoiceRepository;

	@Autowired
	public InvoiceService(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}
	
	public Invoice addInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	public void deleteInvoice(Long id) {
		invoiceRepository.deleteById(id);
	}
	
	public Invoice updateInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	public List<Invoice> findAllInvoices(){
		return invoiceRepository.findAll();
	}
	
	public Invoice findInvoiceById(Long id) {
		return invoiceRepository.findById(id).orElseThrow(() -> new UserNotFoundException ("Property by id " + id + " was not found"));
	}
	
}
