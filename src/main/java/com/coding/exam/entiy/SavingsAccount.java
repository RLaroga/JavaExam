package com.coding.exam.entiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SavingsAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountNumber;
    private String accountType;
    private double availableBalance;

    @ManyToOne
    private Customer customer;

    public SavingsAccount() {
    }
}
