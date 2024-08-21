// src/main/java/com/rk/dto/MaintenanceRequestDto.java
package com.rk.model;

import java.time.LocalDateTime;

import com.rk.entity.Room;

public class MaintenanceRequestDto {
    private String description;
    private String status;
    private Room room; // Or Room ID
    private String reportedBy;
    private LocalDateTime requestTime;
    private LocalDateTime completionTime;
    private Long technicianAssignedId; // ID of the Staff
    private String notes;
    private String priority;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters
}
