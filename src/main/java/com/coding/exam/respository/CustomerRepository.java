package com.coding.exam.respository;

import com.coding.exam.entiy.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
