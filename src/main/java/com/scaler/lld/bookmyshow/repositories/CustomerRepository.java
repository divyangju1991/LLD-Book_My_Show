package com.scaler.lld.bookmyshow.repositories;

import java.util.List;
import java.util.Optional;

import com.scaler.lld.bookmyshow.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    Optional<Customer> findCustomerByPhone(String phone);

    Optional<Customer> findCustomerByEmail(String email);

    List<Customer> findAllByEmailContaining(String containingWord);
}
