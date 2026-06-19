package com.koyuki.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koyuki.demo.entity.TreatmentResult;

public interface TreatmentResultRepository extends JpaRepository<TreatmentResult, Long> {

}