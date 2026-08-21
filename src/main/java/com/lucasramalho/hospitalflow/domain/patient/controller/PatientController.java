package com.lucasramalho.hospitalflow.domain.patient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.lucasramalho.hospitalflow.domain.patient.entity.Patient;
import com.lucasramalho.hospitalflow.domain.patient.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @PostMapping
    public Patient cadastrarPaciente(@RequestBody Patient patient) {
        return patientService.cadastrarPaciente(patient);
    }
}