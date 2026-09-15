package com.lucasramalho.hospitalflow.domain.hospitalization.entity;

import com.lucasramalho.hospitalflow.domain.hospitalization.enums.HospitalizationStatus;
import com.lucasramalho.hospitalflow.domain.patient.entity.Patient;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "hospitalizations")
public class Hospitalization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HospitalizationStatus status;

    private LocalDateTime admissionDate;

    private LocalDateTime dischargeDate;

    private String reason;

    public Hospitalization() {
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public HospitalizationStatus getStatus() {
        return status;
    }

    public void setStatus(HospitalizationStatus status) {
        this.status = status;
    }

    public LocalDateTime getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDateTime admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDateTime getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDateTime dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}