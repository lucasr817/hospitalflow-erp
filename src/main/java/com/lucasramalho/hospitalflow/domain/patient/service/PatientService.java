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

        Patient pacienteSalvo = patientRepository.save(patient);

        if (pacienteSalvo.getMedicalRecordNumber() == null ||
                pacienteSalvo.getMedicalRecordNumber().isBlank()) {

            String medicalRecordNumber =
                    String.format("PRT-%06d", pacienteSalvo.getId());

            pacienteSalvo.setMedicalRecordNumber(medicalRecordNumber);

            pacienteSalvo = patientRepository.save(pacienteSalvo);
        }

        return pacienteSalvo;
    }
}