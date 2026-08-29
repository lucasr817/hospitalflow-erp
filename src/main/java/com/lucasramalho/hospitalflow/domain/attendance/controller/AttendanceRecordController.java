package com.lucasramalho.hospitalflow.domain.attendance.controller;

import com.lucasramalho.hospitalflow.domain.attendance.dto.AttendanceRecordResponse;
import com.lucasramalho.hospitalflow.domain.attendance.dto.CreateAttendanceRecordRequest;
import com.lucasramalho.hospitalflow.domain.attendance.service.AttendanceRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/attendance-records")
public class AttendanceRecordController {

    private final AttendanceRecordService attendanceRecordService;

    public AttendanceRecordController(
            AttendanceRecordService attendanceRecordService) {

        this.attendanceRecordService = attendanceRecordService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendanceRecordResponse> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                attendanceRecordService.buscarPorIdResponse(id)
        );
    }

    @GetMapping("/queue")
    public ResponseEntity<List<AttendanceRecordResponse>> buscarFila() {

        return ResponseEntity.ok(
                attendanceRecordService.buscarFila()
        );
    }
    @PostMapping
    public ResponseEntity<AttendanceRecordResponse> criarFicha(
            @RequestBody CreateAttendanceRecordRequest request) {

        return ResponseEntity.ok(
                attendanceRecordService.criarFicha(request)
        );
    }

    @PutMapping("/{id}/start")
    public ResponseEntity<AttendanceRecordResponse> iniciarAtendimento(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                attendanceRecordService.iniciarAtendimento(id)
        );
    }

    @PutMapping("/{id}/finish")
    public ResponseEntity<AttendanceRecordResponse> finalizarAtendimento(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                attendanceRecordService.finalizarAtendimento(id)
        );
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<AttendanceRecordResponse> cancelarAtendimento(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                attendanceRecordService.cancelarAtendimento(id)
        );
    }
}