package com.coding.exam.service;

import com.coding.exam.dto.CustomerResponseDTO;
import com.coding.exam.request.CustomerRequest;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    ResponseEntity<?> createCustomer(CustomerRequest customerRequest);
    CustomerResponseDTO getCustomerResponseById(Long id);
}
