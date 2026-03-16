package com.example.exp5.repository;

import com.example.exp5.entity.SmartDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartDeviceRepository extends JpaRepository<SmartDevice, Long> {
}
