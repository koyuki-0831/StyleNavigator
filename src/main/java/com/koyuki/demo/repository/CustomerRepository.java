package com.koyuki.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koyuki.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
