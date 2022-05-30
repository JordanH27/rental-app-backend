package com.webapp.rentalapp;

import java.io.FileNotFoundException;
import java.util.List;

import javax.mail.MessagingException;

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

import com.webapp.rentalapp.model.Invoice;
import com.webapp.rentalapp.service.InvoiceService;
import com.webapp.rentalapp.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
	private final InvoiceService invoiceService;
	private final ReportService reportService;
	
	public InvoiceController(InvoiceService invoiceService, ReportService reportService) {
		this.invoiceService = invoiceService;
		this.reportService = reportService;
	}

	@PostMapping("/add")
	public ResponseEntity<Invoice> addInvoice(@RequestBody Invoice invoice){
		Invoice newInvoice = invoiceService.addInvoice(invoice);
		return new ResponseEntity<>(newInvoice, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Invoice> updateInvoice(@RequestBody Invoice invoice){
		Invoice updatedInvoice = invoiceService.updateInvoice(invoice);
		return new ResponseEntity<>(updatedInvoice, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Invoice>> getAllInvoice(){
		List<Invoice> invoice = invoiceService.findAllInvoices();
		return new ResponseEntity<>(invoice, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteInvoice(@PathVariable("id") Long id){
		invoiceService.deleteInvoice(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Invoice> findInvoice(@PathVariable("id") Long id){
		Invoice invoice = invoiceService.findInvoiceById(id);
		return new ResponseEntity<>(invoice, HttpStatus.OK);
	}
	
	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException, MessagingException {
		return reportService.exportReport(format);
	}
		
}
