package com.lucasramalho.hospitalflow.domain.attendance.dto;

import com.lucasramalho.hospitalflow.domain.attendance.enums.AttendanceStatus;
import com.lucasramalho.hospitalflow.domain.attendance.enums.AttendanceType;

import java.time.LocalDateTime;

public class AttendanceRecordResponse {

    private Long id;
    private Long patientId;
    private String patientName;
    private String medicalRecordNumber;
    private LocalDateTime createdAt;
    private AttendanceType attendanceType;
    private AttendanceStatus status;

    public AttendanceRecordResponse(
            Long id,
            Long patientId,
            String patientName,
            String medicalRecordNumber,
            LocalDateTime createdAt,
            AttendanceType attendanceType,
            AttendanceStatus status) {

        this.id = id;
        this.patientId = patientId;
        this.patientName = patientName;
        this.medicalRecordNumber = medicalRecordNumber;
        this.createdAt = createdAt;
        this.attendanceType = attendanceType;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public AttendanceType getAttendanceType() {
        return attendanceType;
    }

    public AttendanceStatus getStatus() {
        return status;
    }
}