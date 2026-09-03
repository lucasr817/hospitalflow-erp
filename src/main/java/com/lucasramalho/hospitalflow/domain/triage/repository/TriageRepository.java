package com.lucasramalho.hospitalflow.domain.triage.repository;

import com.lucasramalho.hospitalflow.domain.triage.entity.Triage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriageRepository extends JpaRepository<Triage, Long> {

    boolean existsByAttendanceRecordId(Long attendanceRecordId);
}