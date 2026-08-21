package com.lucasramalho.hospitalflow.domain.patient.repository;

import com.lucasramalho.hospitalflow.domain.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}