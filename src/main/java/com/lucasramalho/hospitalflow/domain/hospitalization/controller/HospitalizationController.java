package com.lucasramalho.hospitalflow.domain.hospitalization.controller;

import com.lucasramalho.hospitalflow.domain.hospitalization.dto.CreateHospitalizationRequest;
import com.lucasramalho.hospitalflow.domain.hospitalization.dto.HospitalizationResponse;
import com.lucasramalho.hospitalflow.domain.hospitalization.entity.Hospitalization;
import com.lucasramalho.hospitalflow.domain.hospitalization.service.HospitalizationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospitalizations")
public class HospitalizationController {

    private final HospitalizationService hospitalizationService;

    public HospitalizationController(HospitalizationService hospitalizationService) {
        this.hospitalizationService = hospitalizationService;
    }

    @PostMapping
    public ResponseEntity<HospitalizationResponse> criar(
            @Valid @RequestBody CreateHospitalizationRequest request) {

        Hospitalization hospitalization =
                hospitalizationService.criar(request);

        return ResponseEntity.ok(
                HospitalizationResponse.fromEntity(hospitalization)
        );
    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<HospitalizationResponse> confirmar(
            @PathVariable Long id) {

        Hospitalization hospitalization =
                hospitalizationService.confirmar(id);

        return ResponseEntity.ok(
                HospitalizationResponse.fromEntity(hospitalization)
        );
    }

    @PutMapping("/{id}/discharge")
    public ResponseEntity<HospitalizationResponse> darAlta(
            @PathVariable Long id) {

        Hospitalization hospitalization =
                hospitalizationService.darAlta(id);

        return ResponseEntity.ok(
                HospitalizationResponse.fromEntity(hospitalization)
        );
    }

    @PutMapping("/{id}/death")
    public ResponseEntity<HospitalizationResponse> registrarObito(
            @PathVariable Long id) {

        Hospitalization hospitalization =
                hospitalizationService.registrarObito(id);

        return ResponseEntity.ok(
                HospitalizationResponse.fromEntity(hospitalization)
        );
    }

    @PutMapping("/{id}/transfer")
    public ResponseEntity<HospitalizationResponse> registrarTransferencia(
            @PathVariable Long id) {

        Hospitalization hospitalization =
                hospitalizationService.registrarTransferencia(id);

        return ResponseEntity.ok(
                HospitalizationResponse.fromEntity(hospitalization)
        );
    }
}