package com.koyuki.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koyuki.demo.entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {
	List<Visit> findByCustomerId(Long customerId);
}
