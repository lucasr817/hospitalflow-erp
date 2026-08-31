package com.lucasramalho.hospitalflow.domain.triage.controller;

import com.lucasramalho.hospitalflow.domain.triage.dto.CreateTriageRequest;
import com.lucasramalho.hospitalflow.domain.triage.dto.TriageResponse;
import com.lucasramalho.hospitalflow.domain.triage.entity.Triage;
import com.lucasramalho.hospitalflow.domain.triage.service.TriageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/triages")
public class TriageController {

    private final TriageService triageService;

    public TriageController(TriageService triageService) {
        this.triageService = triageService;
    }

    @PostMapping
    public ResponseEntity<TriageResponse> realizarTriagem(
            @Valid @RequestBody CreateTriageRequest request) {

        Triage triage = triageService.realizarTriagem(request);

        TriageResponse response = TriageResponse.fromEntity(triage);

        return ResponseEntity.ok(response);
    }
}