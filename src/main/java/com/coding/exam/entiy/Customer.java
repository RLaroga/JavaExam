package com.coding.exam.entiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;

    @OneToMany(mappedBy = "customer")
    private List<SavingsAccount> savings;

}
