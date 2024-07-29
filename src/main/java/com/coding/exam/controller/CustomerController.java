package com.coding.exam.controller;


import com.coding.exam.dto.CustomerResponseDTO;
import com.coding.exam.request.CustomerRequest;
import com.coding.exam.response.ErrorResponse;
import com.coding.exam.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/account")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        return customerService.createCustomer(customerRequest);
    }

    @GetMapping("{customerNumber}")
    public ResponseEntity<?> getCustomerByNumber(@PathVariable("customerNumber") Long customerNumber) {
        CustomerResponseDTO response = customerService.getCustomerResponseById(customerNumber);

        if (response.getTransactionStatusCode() == 302) {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(response);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(401, "Customer not found"));
        }
    }
}
