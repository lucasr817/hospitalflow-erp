package com.lucasramalho.hospitalflow.domain.attendance.dto;

import com.lucasramalho.hospitalflow.domain.attendance.enums.AttendanceType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CreateAttendanceRecordRequest {

    @NotNull(message = "O paciente é obrigatório")
    private Long patientId;

    private LocalDateTime createdAt;

    @NotNull(message = "O tipo de atendimento é obrigatório")
    private AttendanceType attendanceType;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public AttendanceType getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(AttendanceType attendanceType) {
        this.attendanceType = attendanceType;
    }
}