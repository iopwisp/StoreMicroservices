package com.example.payment_service.service;

import com.example.payment_service.model.Payment;
import com.example.payment_service.model.Status;
import com.example.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repository;

    public List<Payment> getAll() {
        return repository.findAll();
    }

    public Payment getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Payment processPayment(Payment payment) {
        payment.setStatus(Status.PENDING);
        payment.setPaidAt(LocalDateTime.now());
        return repository.save(payment);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
