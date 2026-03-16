package com.example.exp5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class SmartDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Device name is mandatory")
    private String name;

    @NotBlank(message = "Category is mandatory")
    private String category;

    private String status = "Offline"; // Online or Offline

    @Min(0) @Max(100)
    private Integer batteryLevel = 100;

    private String description;

    public SmartDevice() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getBatteryLevel() { return batteryLevel; }
    public void setBatteryLevel(Integer batteryLevel) { this.batteryLevel = batteryLevel; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
