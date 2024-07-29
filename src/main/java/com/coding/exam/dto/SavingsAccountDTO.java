package com.coding.exam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccountDTO {
    private Long accountNumber;
    private String accountType;
    private double availableBalance;

    public SavingsAccountDTO(Long accountNumber, String accountType, double availableBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.availableBalance = availableBalance;
    }
}