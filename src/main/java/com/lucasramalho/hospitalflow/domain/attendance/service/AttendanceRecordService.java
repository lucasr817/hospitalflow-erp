package com.lucasramalho.hospitalflow.domain.attendance.service;

import com.lucasramalho.hospitalflow.domain.attendance.dto.CreateAttendanceRecordRequest;
import com.lucasramalho.hospitalflow.domain.attendance.entity.AttendanceRecord;
import com.lucasramalho.hospitalflow.domain.attendance.repository.AttendanceRecordRepository;
import com.lucasramalho.hospitalflow.domain.patient.entity.Patient;
import com.lucasramalho.hospitalflow.domain.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class AttendanceRecordService {

    private final AttendanceRecordRepository attendanceRecordRepository;
    private final PatientRepository patientRepository;

    public AttendanceRecordService(
            AttendanceRecordRepository attendanceRecordRepository,
            PatientRepository patientRepository) {

        this.attendanceRecordRepository = attendanceRecordRepository;
        this.patientRepository = patientRepository;
    }

    public AttendanceRecord criarFicha(CreateAttendanceRecordRequest request) {

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        AttendanceRecord attendanceRecord = new AttendanceRecord();

        attendanceRecord.setPatient(patient);
        attendanceRecord.setCreatedAt(request.getCreatedAt());
        attendanceRecord.setAttendanceType(request.getAttendanceType());
        attendanceRecord.setStatus(request.getStatus());

        return attendanceRecordRepository.save(attendanceRecord);
    }
}