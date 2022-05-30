package com.webapp.rentalapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.webapp.rentalapp.model.PaymentReceived;

@Repository
public interface PaymentReceivedRepository extends JpaRepository<PaymentReceived, Long>{
	Optional<PaymentReceived> findById(Long id);
}
