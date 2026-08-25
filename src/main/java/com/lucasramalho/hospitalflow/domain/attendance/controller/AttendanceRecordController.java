package com.lucasramalho.hospitalflow.domain.attendance.controller;

import com.lucasramalho.hospitalflow.domain.attendance.dto.CreateAttendanceRecordRequest;
import com.lucasramalho.hospitalflow.domain.attendance.entity.AttendanceRecord;
import com.lucasramalho.hospitalflow.domain.attendance.service.AttendanceRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance-records")
public class AttendanceRecordController {

    private final AttendanceRecordService attendanceRecordService;

    public AttendanceRecordController(AttendanceRecordService attendanceRecordService) {
        this.attendanceRecordService = attendanceRecordService;
    }

    @PostMapping
    public ResponseEntity<AttendanceRecord> criarFicha(
            @RequestBody CreateAttendanceRecordRequest request) {

        AttendanceRecord createdRecord =
                attendanceRecordService.criarFicha(request);

        return ResponseEntity.ok(createdRecord);
    }
}