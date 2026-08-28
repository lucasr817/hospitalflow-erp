package com.lucasramalho.hospitalflow.domain.attendance.dto;

import com.lucasramalho.hospitalflow.domain.attendance.enums.AttendanceType;

import java.time.LocalDateTime;

public class CreateAttendanceRecordRequest {

    private Long patientId;

    private LocalDateTime createdAt;

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