package com.lucasramalho.hospitalflow.domain.patient.service;

import org.springframework.stereotype.Service;

import com.lucasramalho.hospitalflow.domain.patient.entity.Patient;
import com.lucasramalho.hospitalflow.domain.patient.repository.PatientRepository;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient cadastrarPaciente(Patient patient) {

        if (patient.getMedicalRecordNumber() == null ||
                patient.getMedicalRecordNumber().isBlank()) {

            patient.setMedicalRecordNumber("PRT-" + System.currentTimeMillis());
        }

        return patientRepository.save(patient);
    }
}