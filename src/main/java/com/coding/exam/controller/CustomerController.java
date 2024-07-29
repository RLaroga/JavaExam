package com.coding.exam.controller;


import com.coding.exam.request.CustomerRequest;
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
        return new ResponseEntity<>(customerService.saveCustomer(customerRequest), HttpStatus.CREATED);
    }

}
