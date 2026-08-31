package com.lucasramalho.hospitalflow.domain.triage.dto;

import com.lucasramalho.hospitalflow.domain.triage.entity.Triage;
import com.lucasramalho.hospitalflow.domain.triage.enums.RiskClassification;

import java.time.LocalDateTime;

public class TriageResponse {

    private Long id;
    private Long attendanceRecordId;

    private String mainComplaint;
    private String symptomHistory;
    private Integer painIntensity;
    private String painRadiation;

    private String medicalHistory;
    private String continuousMedications;
    private String allergies;
    private String recentContext;

    private Integer heartRate;
    private String bloodPressure;
    private Integer respiratoryRate;
    private Integer oxygenSaturation;
    private Double temperature;
    private Integer capillaryBloodGlucose;

    private String consciousnessLevel;
    private String generalAppearance;

    private RiskClassification riskClassification;

    private LocalDateTime createdAt;

    public TriageResponse() {
    }

    public static TriageResponse fromEntity(Triage triage) {

        TriageResponse response = new TriageResponse();

        response.id = triage.getId();

        response.attendanceRecordId =
                triage.getAttendanceRecord().getId();

        response.mainComplaint =
                triage.getMainComplaint();

        response.symptomHistory =
                triage.getSymptomHistory();

        response.painIntensity =
                triage.getPainIntensity();

        response.painRadiation =
                triage.getPainRadiation();

        response.medicalHistory =
                triage.getMedicalHistory();

        response.continuousMedications =
                triage.getContinuousMedications();

        response.allergies =
                triage.getAllergies();

        response.recentContext =
                triage.getRecentContext();

        response.heartRate =
                triage.getHeartRate();

        response.bloodPressure =
                triage.getBloodPressure();

        response.respiratoryRate =
                triage.getRespiratoryRate();

        response.oxygenSaturation =
                triage.getOxygenSaturation();

        response.temperature =
                triage.getTemperature();

        response.capillaryBloodGlucose =
                triage.getCapillaryBloodGlucose();

        response.consciousnessLevel =
                triage.getConsciousnessLevel();

        response.generalAppearance =
                triage.getGeneralAppearance();

        response.riskClassification =
                triage.getRiskClassification();

        response.createdAt =
                triage.getCreatedAt();

        return response;
    }

    public Long getId() {
        return id;
    }

    public Long getAttendanceRecordId() {
        return attendanceRecordId;
    }

    public String getMainComplaint() {
        return mainComplaint;
    }

    public String getSymptomHistory() {
        return symptomHistory;
    }

    public Integer getPainIntensity() {
        return painIntensity;
    }

    public String getPainRadiation() {
        return painRadiation;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getContinuousMedications() {
        return continuousMedications;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getRecentContext() {
        return recentContext;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public Integer getRespiratoryRate() {
        return respiratoryRate;
    }

    public Integer getOxygenSaturation() {
        return oxygenSaturation;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Integer getCapillaryBloodGlucose() {
        return capillaryBloodGlucose;
    }

    public String getConsciousnessLevel() {
        return consciousnessLevel;
    }

    public String getGeneralAppearance() {
        return generalAppearance;
    }

    public RiskClassification getRiskClassification() {
        return riskClassification;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}