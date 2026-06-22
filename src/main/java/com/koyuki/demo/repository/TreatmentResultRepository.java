package com.koyuki.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koyuki.demo.entity.TreatmentResult;

public interface TreatmentResultRepository
        extends JpaRepository<TreatmentResult, Long> {

    Optional<TreatmentResult> findByVisitId(Long visitId);

}