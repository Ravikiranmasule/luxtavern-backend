package com.rk.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String position;

    @OneToMany(mappedBy = "assignedTo")
    @JsonManagedReference
    private Set<HousekeepingSchedule> assignedSchedules;

    @OneToMany(mappedBy = "technicianAssigned")
    @JsonManagedReference
    private Set<MaintenanceRequest> assignedRequests;
}
