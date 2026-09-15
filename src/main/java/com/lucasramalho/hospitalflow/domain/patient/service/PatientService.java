package com.lucasramalho.hospitalflow.domain.patient.service;

import com.lucasramalho.hospitalflow.domain.patient.dto.CreatePatientRequest;
import com.lucasramalho.hospitalflow.domain.patient.entity.Patient;
import com.lucasramalho.hospitalflow.domain.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient cadastrarPaciente(CreatePatientRequest request) {

        Patient patient = new Patient();

        patient.setFullName(request.getFullName());
        patient.setBirthDate(request.getBirthDate());
        patient.setCpf(request.getCpf());

        Patient pacienteSalvo = patientRepository.save(patient);

        String medicalRecordNumber =
                String.format("PRT-%06d", pacienteSalvo.getId());

        pacienteSalvo.setMedicalRecordNumber(medicalRecordNumber);

        return patientRepository.save(pacienteSalvo);
    }
}