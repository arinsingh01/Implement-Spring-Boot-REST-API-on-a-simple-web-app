package com.example.exp5.service;

import com.example.exp5.entity.SmartDevice;
import com.example.exp5.exception.ResourceNotFoundException;
import com.example.exp5.repository.SmartDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartDeviceServiceImpl implements SmartDeviceService {

    @Autowired
    private SmartDeviceRepository repository;

    @Override
    public List<SmartDevice> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public SmartDevice getDeviceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id: " + id));
    }

    @Override
    public SmartDevice createDevice(SmartDevice device) {
        return repository.save(device);
    }

    @Override
    public SmartDevice updateDevice(Long id, SmartDevice device) {
        SmartDevice existing = getDeviceById(id);
        existing.setName(device.getName());
        existing.setCategory(device.getCategory());
        existing.setDescription(device.getDescription());
        existing.setBatteryLevel(device.getBatteryLevel());
        return repository.save(existing);
    }

    @Override
    public void deleteDevice(Long id) {
        SmartDevice existing = getDeviceById(id);
        repository.delete(existing);
    }

    @Override
    public SmartDevice toggleStatus(Long id) {
        SmartDevice device = getDeviceById(id);
        device.setStatus("Online".equals(device.getStatus()) ? "Offline" : "Online");
        return repository.save(device);
    }
}
