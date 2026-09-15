package com.lucasramalho.hospitalflow.domain.patient.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreatePatientRequest {

    @NotBlank(message = "O nome do paciente é obrigatório")
    private String fullName;

    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate birthDate;

    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}