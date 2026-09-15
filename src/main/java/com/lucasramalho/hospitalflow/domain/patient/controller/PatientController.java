package com.lucasramalho.hospitalflow.domain.patient.controller;

import com.lucasramalho.hospitalflow.domain.patient.dto.CreatePatientRequest;
import com.lucasramalho.hospitalflow.domain.patient.entity.Patient;
import com.lucasramalho.hospitalflow.domain.patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patient> cadastrarPaciente(
            @Valid @RequestBody CreatePatientRequest request) {

        Patient patient = patientService.cadastrarPaciente(request);

        return ResponseEntity.ok(patient);
    }
}