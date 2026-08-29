package com.lucasramalho.hospitalflow.domain.attendance.service;

import com.lucasramalho.hospitalflow.domain.attendance.dto.AttendanceRecordResponse;
import com.lucasramalho.hospitalflow.domain.attendance.dto.CreateAttendanceRecordRequest;
import com.lucasramalho.hospitalflow.domain.attendance.entity.AttendanceRecord;
import com.lucasramalho.hospitalflow.domain.attendance.enums.AttendanceStatus;
import com.lucasramalho.hospitalflow.domain.attendance.repository.AttendanceRecordRepository;
import com.lucasramalho.hospitalflow.domain.patient.entity.Patient;
import com.lucasramalho.hospitalflow.domain.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class AttendanceRecordService {

    private final AttendanceRecordRepository attendanceRecordRepository;
    private final PatientRepository patientRepository;

    public AttendanceRecordService(
            AttendanceRecordRepository attendanceRecordRepository,
            PatientRepository patientRepository) {

        this.attendanceRecordRepository = attendanceRecordRepository;
        this.patientRepository = patientRepository;
    }

    public List<AttendanceRecordResponse> buscarFila() {

        List<AttendanceRecord> atendimentos =
                attendanceRecordRepository.findByStatusOrderByCreatedAtAsc(
                        AttendanceStatus.AGUARDANDO
                );

        return atendimentos.stream()
                .map(this::toResponse)
                .toList();
    }

    public AttendanceRecordResponse criarFicha(
            CreateAttendanceRecordRequest request) {

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() ->
                        new RuntimeException("Paciente não encontrado"));

        AttendanceRecord attendanceRecord = new AttendanceRecord();

        attendanceRecord.setPatient(patient);
        attendanceRecord.setCreatedAt(request.getCreatedAt());
        attendanceRecord.setAttendanceType(request.getAttendanceType());
        attendanceRecord.setStatus(AttendanceStatus.AGUARDANDO);

        AttendanceRecord saved =
                attendanceRecordRepository.save(attendanceRecord);

        return toResponse(saved);
    }

    public AttendanceRecordResponse iniciarAtendimento(Long id) {

        AttendanceRecord attendanceRecord = buscarPorId(id);

        if (attendanceRecord.getStatus() != AttendanceStatus.AGUARDANDO) {
            throw new IllegalStateException(
                    "O atendimento precisa estar AGUARDANDO para ser iniciado"
            );
        }

        attendanceRecord.setStatus(AttendanceStatus.EM_ATENDIMENTO);

        AttendanceRecord saved =
                attendanceRecordRepository.save(attendanceRecord);

        return toResponse(saved);
    }

    public AttendanceRecordResponse finalizarAtendimento(Long id) {

        AttendanceRecord attendanceRecord = buscarPorId(id);

        if (attendanceRecord.getStatus() != AttendanceStatus.EM_ATENDIMENTO) {
            throw new IllegalStateException(
                    "O atendimento precisa estar EM_ATENDIMENTO para ser finalizado"
            );
        }

        attendanceRecord.setStatus(AttendanceStatus.FINALIZADO);

        AttendanceRecord saved =
                attendanceRecordRepository.save(attendanceRecord);

        return toResponse(saved);
    }

    public AttendanceRecordResponse cancelarAtendimento(Long id) {

        AttendanceRecord attendanceRecord = buscarPorId(id);

        if (attendanceRecord.getStatus() == AttendanceStatus.FINALIZADO) {
            throw new IllegalStateException(
                    "Não é possível cancelar um atendimento finalizado"
            );
        }

        attendanceRecord.setStatus(AttendanceStatus.CANCELADO);

        AttendanceRecord saved =
                attendanceRecordRepository.save(attendanceRecord);

        return toResponse(saved);
    }

    private AttendanceRecord buscarPorId(Long id) {

        return attendanceRecordRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Ficha de atendimento não encontrada"
                        ));
    }

    private AttendanceRecordResponse toResponse(
            AttendanceRecord attendanceRecord) {

        return new AttendanceRecordResponse(
                attendanceRecord.getId(),
                attendanceRecord.getPatient().getId(),
                attendanceRecord.getPatient().getFullName(),
                attendanceRecord.getPatient().getMedicalRecordNumber(),
                attendanceRecord.getCreatedAt(),
                attendanceRecord.getAttendanceType(),
                attendanceRecord.getStatus()
        );
    }
    public AttendanceRecordResponse buscarPorIdResponse(Long id) {

        AttendanceRecord attendanceRecord = buscarPorId(id);

        return toResponse(attendanceRecord);
    }

}