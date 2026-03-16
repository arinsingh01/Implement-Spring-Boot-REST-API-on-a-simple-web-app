package com.example.exp5.service;

import com.example.exp5.entity.SmartDevice;
import java.util.List;

public interface SmartDeviceService {
    List<SmartDevice> getAllDevices();
    SmartDevice getDeviceById(Long id);
    SmartDevice createDevice(SmartDevice device);
    SmartDevice updateDevice(Long id, SmartDevice device);
    void deleteDevice(Long id);
    SmartDevice toggleStatus(Long id);
}
