package com.lucasramalho.hospitalflow.hospitalization;

import com.lucasramalho.hospitalflow.domain.hospitalization.entity.Hospitalization;
import com.lucasramalho.hospitalflow.domain.hospitalization.enums.HospitalizationStatus;
import com.lucasramalho.hospitalflow.domain.hospitalization.repository.HospitalizationRepository;
import com.lucasramalho.hospitalflow.domain.hospitalization.service.HospitalizationService;
import com.lucasramalho.hospitalflow.shared.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HospitalizationServiceTest {

    @Mock
    private HospitalizationRepository hospitalizationRepository;

    @InjectMocks
    private HospitalizationService hospitalizationService;

    @Test
    void deveConfirmarInternacao() {

        Hospitalization hospitalization = new Hospitalization();

        hospitalization.setStatus(HospitalizationStatus.AGUARDANDO_ADMISSAO);

        when(hospitalizationRepository.findById(1L))
                .thenReturn(Optional.of(hospitalization));

        when(hospitalizationRepository.save(hospitalization))
                .thenReturn(hospitalization);

        Hospitalization resultado =
                hospitalizationService.confirmar(1L);

        assertEquals(
                HospitalizationStatus.INTERNADO,
                resultado.getStatus()
        );
    }

    @Test
    void naoDeveConfirmarInternacaoQueJaEstaInternada() {

        Hospitalization hospitalization = new Hospitalization();

        hospitalization.setStatus(HospitalizationStatus.INTERNADO);

        when(hospitalizationRepository.findById(1L))
                .thenReturn(Optional.of(hospitalization));

        assertThrows(
                BusinessException.class,
                () -> hospitalizationService.confirmar(1L)
        );
    }

    @Test
    void deveDarAltaNaInternacao() {

        Hospitalization hospitalization = new Hospitalization();

        hospitalization.setStatus(HospitalizationStatus.INTERNADO);

        when(hospitalizationRepository.findById(1L))
                .thenReturn(Optional.of(hospitalization));

        when(hospitalizationRepository.save(hospitalization))
                .thenReturn(hospitalization);

        Hospitalization resultado =
                hospitalizationService.darAlta(1L);

        assertEquals(
                HospitalizationStatus.ALTA,
                resultado.getStatus()
        );
    }

    @Test
    void naoDeveDarAltaSeNaoEstiverInternado() {

        Hospitalization hospitalization = new Hospitalization();

        hospitalization.setStatus(HospitalizationStatus.AGUARDANDO_ADMISSAO);

        when(hospitalizationRepository.findById(1L))
                .thenReturn(Optional.of(hospitalization));

        assertThrows(
                BusinessException.class,
                () -> hospitalizationService.darAlta(1L)
        );
    }
}