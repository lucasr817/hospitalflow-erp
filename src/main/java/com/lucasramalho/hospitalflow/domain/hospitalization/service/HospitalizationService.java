package com.lucasramalho.hospitalflow.domain.hospitalization.service;

import com.lucasramalho.hospitalflow.domain.hospitalization.dto.CreateHospitalizationRequest;
import com.lucasramalho.hospitalflow.domain.hospitalization.entity.Hospitalization;
import com.lucasramalho.hospitalflow.domain.hospitalization.enums.HospitalizationStatus;
import com.lucasramalho.hospitalflow.domain.hospitalization.repository.HospitalizationRepository;
import com.lucasramalho.hospitalflow.domain.patient.entity.Patient;
import com.lucasramalho.hospitalflow.domain.patient.repository.PatientRepository;
import com.lucasramalho.hospitalflow.shared.exception.BusinessException;
import com.lucasramalho.hospitalflow.shared.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class HospitalizationService {

    private final HospitalizationRepository hospitalizationRepository;
    private final PatientRepository patientRepository;

    public HospitalizationService(
            HospitalizationRepository hospitalizationRepository,
            PatientRepository patientRepository) {

        this.hospitalizationRepository = hospitalizationRepository;
        this.patientRepository = patientRepository;
    }

    public Hospitalization criar(CreateHospitalizationRequest request) {

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Paciente não encontrado"));

        Hospitalization hospitalization = new Hospitalization();

        hospitalization.setPatient(patient);
        hospitalization.setStatus(HospitalizationStatus.AGUARDANDO_ADMISSAO);
        hospitalization.setAdmissionDate(request.getAdmissionDate());
        hospitalization.setReason(request.getReason());

        return hospitalizationRepository.save(hospitalization);
    }

    public Hospitalization confirmar(Long id) {

        Hospitalization hospitalization = buscarPorId(id);

        if (hospitalization.getStatus() != HospitalizationStatus.AGUARDANDO_ADMISSAO) {
            throw new BusinessException(
                    "A internação não está aguardando admissão"
            );
        }

        hospitalization.setStatus(HospitalizationStatus.INTERNADO);

        if (hospitalization.getAdmissionDate() == null) {
            hospitalization.setAdmissionDate(LocalDateTime.now());
        }

        return hospitalizationRepository.save(hospitalization);
    }

    public Hospitalization darAlta(Long id) {

        Hospitalization hospitalization = buscarPorId(id);

        validarInternado(hospitalization);

        hospitalization.setStatus(HospitalizationStatus.ALTA);
        hospitalization.setDischargeDate(LocalDateTime.now());

        return hospitalizationRepository.save(hospitalization);
    }

    public Hospitalization registrarObito(Long id) {

        Hospitalization hospitalization = buscarPorId(id);

        validarInternado(hospitalization);

        hospitalization.setStatus(HospitalizationStatus.OBITO);
        hospitalization.setDischargeDate(LocalDateTime.now());

        return hospitalizationRepository.save(hospitalization);
    }

    public Hospitalization registrarTransferencia(Long id) {

        Hospitalization hospitalization = buscarPorId(id);

        validarInternado(hospitalization);

        hospitalization.setStatus(HospitalizationStatus.TRANSFERIDO);
        hospitalization.setDischargeDate(LocalDateTime.now());

        return hospitalizationRepository.save(hospitalization);
    }

    private Hospitalization buscarPorId(Long id) {

        return hospitalizationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Internação não encontrada"));
    }

    private void validarInternado(Hospitalization hospitalization) {

        if (hospitalization.getStatus() != HospitalizationStatus.INTERNADO) {
            throw new BusinessException(
                    "O paciente não está internado"
            );
        }
    }
}