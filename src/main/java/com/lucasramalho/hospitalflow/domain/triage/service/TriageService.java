package com.lucasramalho.hospitalflow.domain.triage.service;

import com.lucasramalho.hospitalflow.domain.attendance.entity.AttendanceRecord;
import com.lucasramalho.hospitalflow.domain.attendance.repository.AttendanceRecordRepository;
import com.lucasramalho.hospitalflow.domain.triage.dto.CreateTriageRequest;
import com.lucasramalho.hospitalflow.domain.triage.entity.Triage;
import com.lucasramalho.hospitalflow.domain.triage.repository.TriageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class TriageService {

    private final TriageRepository triageRepository;
    private final AttendanceRecordRepository attendanceRecordRepository;

    public TriageService(
            TriageRepository triageRepository,
            AttendanceRecordRepository attendanceRecordRepository) {

        this.triageRepository = triageRepository;
        this.attendanceRecordRepository = attendanceRecordRepository;
    }

    public Triage realizarTriagem(CreateTriageRequest request) {

        AttendanceRecord attendanceRecord =
                attendanceRecordRepository.findById(
                        request.getAttendanceRecordId()
                ).orElseThrow(() ->
                        new RuntimeException(
                                "Ficha de atendimento não encontrada"
                        ));

        Triage triage = new Triage();

        triage.setAttendanceRecord(attendanceRecord);
        triage.setCreatedAt(LocalDateTime.now());

        triage.setMainComplaint(request.getMainComplaint());
        triage.setSymptomHistory(request.getSymptomHistory());
        triage.setPainIntensity(request.getPainIntensity());
        triage.setPainRadiation(request.getPainRadiation());
        triage.setMedicalHistory(request.getMedicalHistory());

        triage.setContinuousMedications(
                request.getContinuousMedications()
        );

        triage.setAllergies(request.getAllergies());
        triage.setRecentContext(request.getRecentContext());

        triage.setHeartRate(request.getHeartRate());
        triage.setBloodPressure(request.getBloodPressure());
        triage.setRespiratoryRate(request.getRespiratoryRate());
        triage.setOxygenSaturation(request.getOxygenSaturation());
        triage.setTemperature(request.getTemperature());

        triage.setCapillaryBloodGlucose(
                request.getCapillaryBloodGlucose()
        );

        triage.setConsciousnessLevel(
                request.getConsciousnessLevel()
        );

        triage.setGeneralAppearance(
                request.getGeneralAppearance()
        );

        triage.setRiskClassification(
                request.getRiskClassification()
        );

        return triageRepository.save(triage);
    }
}