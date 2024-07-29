package com.coding.exam.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Customer mobile is required")
    private String customerMobile;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String customerEmail;

    @NotBlank(message = "Address1 is required")
    private String address1;

    private String address2;

}
