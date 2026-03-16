package com.example.exp5.controller;

import com.example.exp5.entity.SmartDevice;
import com.example.exp5.service.SmartDeviceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class SmartDeviceController {

    @Autowired
    private SmartDeviceService deviceService;

    @GetMapping
    public List<SmartDevice> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SmartDevice> getDeviceById(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.getDeviceById(id));
    }

    @PostMapping
    public ResponseEntity<SmartDevice> createDevice(@Valid @RequestBody SmartDevice device) {
        return new ResponseEntity<>(deviceService.createDevice(device), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SmartDevice> updateDevice(@PathVariable Long id, @Valid @RequestBody SmartDevice device) {
        return ResponseEntity.ok(deviceService.updateDevice(id, device));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/toggle-status")
    public ResponseEntity<SmartDevice> toggleStatus(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.toggleStatus(id));
    }
}
