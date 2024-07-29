package com.coding.exam.service.impl;

import com.coding.exam.dto.CustomerResponseDTO;
import com.coding.exam.dto.SavingsAccountDTO;
import com.coding.exam.entiy.Customer;
import com.coding.exam.request.CustomerRequest;
import com.coding.exam.response.CustomerResponse;
import com.coding.exam.response.ErrorResponse;
import com.coding.exam.respository.CustomerRepository;
import com.coding.exam.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public ResponseEntity<?> createCustomer(CustomerRequest customerRequest) {
        if (customerRequest.getCustomerEmail() == null || customerRequest.getCustomerEmail().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(400, "Email is required field"));
        }
        Customer savedCustomer = this.saveCustomer(customerRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CustomerResponse(savedCustomer.getId(), 201, "Customer account created"));
    }

    @Override
    public CustomerResponseDTO getCustomerResponseById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            Customer c = customer.get();
            List<SavingsAccountDTO> savingsDTOs = c.getSavings().stream()
                    .map(sa -> new SavingsAccountDTO(sa.getAccountNumber(), sa.getAccountType(), sa.getAvailableBalance()))
                    .collect(Collectors.toList());
            return new CustomerResponseDTO(
                    c.getId(),
                    c.getCustomerName(),
                    c.getCustomerMobile(),
                    c.getCustomerEmail(),
                    c.getAddress1(),
                    c.getAddress2(),
                    savingsDTOs,
                    302,
                    "Customer Account found"
            );
        }
        return new CustomerResponseDTO(null, null, null, null, null, null, null, 401, "Customer not found");
    }

    private Customer saveCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setCustomerName(customerRequest.getCustomerName());
        customer.setCustomerMobile(customerRequest.getCustomerMobile());
        customer.setCustomerEmail(customerRequest.getCustomerEmail());
        customer.setAddress1(customerRequest.getAddress1());
        customer.setAddress2(customerRequest.getAddress2());
        return customerRepository.save(customer);
    }
}