package com.lucasramalho.hospitalflow.domain.hospitalization.repository;

import com.lucasramalho.hospitalflow.domain.hospitalization.entity.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalizationRepository extends JpaRepository<Hospitalization, Long> {
}