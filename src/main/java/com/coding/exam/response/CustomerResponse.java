package com.coding.exam.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
    private long customerNumber;
    private int transactionStatusCode;
    private String transactionStatusDescription;
}
