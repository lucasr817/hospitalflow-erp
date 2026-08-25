package com.lucasramalho.hospitalflow.domain.attendance.repository;

import com.lucasramalho.hospitalflow.domain.attendance.entity.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord, Long> {
}