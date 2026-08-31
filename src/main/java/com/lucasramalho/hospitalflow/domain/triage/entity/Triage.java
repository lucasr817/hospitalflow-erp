package com.lucasramalho.hospitalflow.domain.triage.entity;

import com.lucasramalho.hospitalflow.domain.attendance.entity.AttendanceRecord;
import com.lucasramalho.hospitalflow.domain.triage.enums.RiskClassification;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "triages")
public class Triage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "attendance_record_id",
            nullable = false,
            unique = true
    )
    private AttendanceRecord attendanceRecord;

    @Column(name = "main_complaint", nullable = false, length = 500)
    private String mainComplaint;

    @Column(name = "symptom_history", length = 1000)
    private String symptomHistory;

    @Column(name = "pain_intensity")
    private Integer painIntensity;

    @Column(name = "pain_radiation", length = 255)
    private String painRadiation;

    @Column(name = "medical_history", length = 1000)
    private String medicalHistory;

    @Column(name = "continuous_medications", length = 1000)
    private String continuousMedications;

    @Column(name = "allergies", length = 1000)
    private String allergies;

    @Column(name = "recent_context", length = 1000)
    private String recentContext;

    @Column(name = "heart_rate")
    private Integer heartRate;

    @Column(name = "blood_pressure", length = 20)
    private String bloodPressure;

    @Column(name = "respiratory_rate")
    private Integer respiratoryRate;

    @Column(name = "oxygen_saturation")
    private Integer oxygenSaturation;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "capillary_blood_glucose")
    private Integer capillaryBloodGlucose;

    @Column(name = "consciousness_level", length = 255)
    private String consciousnessLevel;

    @Column(name = "general_appearance", length = 1000)
    private String generalAppearance;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "risk_classification",
            nullable = false,
            length = 30
    )
    private RiskClassification riskClassification;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Triage() {
    }

    public Long getId() {
        return id;
    }

    public AttendanceRecord getAttendanceRecord() {
        return attendanceRecord;
    }

    public void setAttendanceRecord(AttendanceRecord attendanceRecord) {
        this.attendanceRecord = attendanceRecord;
    }

    public String getMainComplaint() {
        return mainComplaint;
    }

    public void setMainComplaint(String mainComplaint) {
        this.mainComplaint = mainComplaint;
    }

    public String getSymptomHistory() {
        return symptomHistory;
    }

    public void setSymptomHistory(String symptomHistory) {
        this.symptomHistory = symptomHistory;
    }

    public Integer getPainIntensity() {
        return painIntensity;
    }

    public void setPainIntensity(Integer painIntensity) {
        this.painIntensity = painIntensity;
    }

    public String getPainRadiation() {
        return painRadiation;
    }

    public void setPainRadiation(String painRadiation) {
        this.painRadiation = painRadiation;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getContinuousMedications() {
        return continuousMedications;
    }

    public void setContinuousMedications(String continuousMedications) {
        this.continuousMedications = continuousMedications;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getRecentContext() {
        return recentContext;
    }

    public void setRecentContext(String recentContext) {
        this.recentContext = recentContext;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Integer getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(Integer respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public Integer getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(Integer oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getCapillaryBloodGlucose() {
        return capillaryBloodGlucose;
    }

    public void setCapillaryBloodGlucose(Integer capillaryBloodGlucose) {
        this.capillaryBloodGlucose = capillaryBloodGlucose;
    }

    public String getConsciousnessLevel() {
        return consciousnessLevel;
    }

    public void setConsciousnessLevel(String consciousnessLevel) {
        this.consciousnessLevel = consciousnessLevel;
    }

    public String getGeneralAppearance() {
        return generalAppearance;
    }

    public void setGeneralAppearance(String generalAppearance) {
        this.generalAppearance = generalAppearance;
    }

    public RiskClassification getRiskClassification() {
        return riskClassification;
    }

    public void setRiskClassification(RiskClassification riskClassification) {
        this.riskClassification = riskClassification;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}