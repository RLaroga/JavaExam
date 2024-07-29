package com.coding.exam.service;

import com.coding.exam.entiy.Customer;
import com.coding.exam.request.CustomerRequest;
import com.coding.exam.response.CustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerService extends JpaRepository<Customer, Long> {
    CustomerResponse saveCustomer(CustomerRequest customerRequest);
}
