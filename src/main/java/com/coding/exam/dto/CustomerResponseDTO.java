package com.coding.exam.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerResponseDTO {
    private Long customerNumber;
    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    private List<SavingsAccountDTO> savings;
    private int transactionStatusCode;
    private String transactionStatusDescription;

    public CustomerResponseDTO(Long customerNumber, String customerName, String customerMobile,
                               String customerEmail, String address1, String address2,
                               List<SavingsAccountDTO> savings, int transactionStatusCode,
                               String transactionStatusDescription) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerEmail = customerEmail;
        this.address1 = address1;
        this.address2 = address2;
        this.savings = savings;
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }
}
