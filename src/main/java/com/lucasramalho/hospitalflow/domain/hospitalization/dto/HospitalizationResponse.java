package com.lucasramalho.hospitalflow.domain.hospitalization.dto;

import com.lucasramalho.hospitalflow.domain.hospitalization.entity.Hospitalization;
import com.lucasramalho.hospitalflow.domain.hospitalization.enums.HospitalizationStatus;

import java.time.LocalDateTime;

public class HospitalizationResponse {

    private Long id;
    private Long patientId;
    private HospitalizationStatus status;
    private LocalDateTime admissionDate;
    private LocalDateTime dischargeDate;
    private String reason;

    public HospitalizationResponse(
            Long id,
            Long patientId,
            HospitalizationStatus status,
            LocalDateTime admissionDate,
            LocalDateTime dischargeDate,
            String reason) {

        this.id = id;
        this.patientId = patientId;
        this.status = status;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.reason = reason;
    }

    public static HospitalizationResponse fromEntity(Hospitalization hospitalization) {

        return new HospitalizationResponse(
                hospitalization.getId(),
                hospitalization.getPatient().getId(),
                hospitalization.getStatus(),
                hospitalization.getAdmissionDate(),
                hospitalization.getDischargeDate(),
                hospitalization.getReason()
        );
    }

    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public HospitalizationStatus getStatus() {
        return status;
    }

    public LocalDateTime getAdmissionDate() {
        return admissionDate;
    }

    public LocalDateTime getDischargeDate() {
        return dischargeDate;
    }

    public String getReason() {
        return reason;
    }
}