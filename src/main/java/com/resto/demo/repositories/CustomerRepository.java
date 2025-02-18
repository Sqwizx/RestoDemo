package com.resto.demo.repositories;

import com.resto.demo.entities.Booking;
import com.resto.demo.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAll(Pageable pageable);

    Customer save(Customer customer);

    Optional<Customer> findById(Long id);

    void deleteById(Long id);

    boolean existsById(Integer integer);

    Customer findByNameAndEmailAndPhone(String name, String email, String phone);
}