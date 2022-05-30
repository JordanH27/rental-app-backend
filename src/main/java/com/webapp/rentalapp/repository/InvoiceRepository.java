package com.webapp.rentalapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.rentalapp.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
	Optional<Invoice> findById(Long id);
}
