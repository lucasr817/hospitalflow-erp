package com.lucasramalho.hospitalflow.domain.attendance.repository;

import com.lucasramalho.hospitalflow.domain.attendance.entity.AttendanceRecord;
import com.lucasramalho.hospitalflow.domain.attendance.enums.AttendanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRecordRepository
        extends JpaRepository<AttendanceRecord, Long> {

    List<AttendanceRecord> findByStatusOrderByCreatedAtAsc(
            AttendanceStatus status
    );
}