package com.lucasramalho.hospitalflow.domain.hospitalization.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CreateHospitalizationRequest {

    @NotNull(message = "O paciente é obrigatório")
    private Long patientId;

    private LocalDateTime admissionDate;

    private String reason;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDateTime admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}