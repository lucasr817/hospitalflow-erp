package com.lucasramalho.hospitalflow.domain.triage.dto;

import com.lucasramalho.hospitalflow.domain.triage.enums.RiskClassification;

public class CreateTriageRequest {

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

    public Long getAttendanceRecordId() {
        return attendanceRecordId;
    }

    public void setAttendanceRecordId(Long attendanceRecordId) {
        this.attendanceRecordId = attendanceRecordId;
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
}