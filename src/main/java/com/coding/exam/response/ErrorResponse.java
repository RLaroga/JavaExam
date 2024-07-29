package com.coding.exam.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private int transactionStatusCode;
    private String transactionStatusDescription;

    public ErrorResponse(int transactionStatusCode, String transactionStatusDescription) {
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }
}
