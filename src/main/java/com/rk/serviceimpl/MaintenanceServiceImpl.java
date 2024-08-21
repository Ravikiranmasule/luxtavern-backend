package com.rk.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.MaintenanceRequest;
import com.rk.entity.Staff;
import com.rk.repository.MaintenanceRepository;
import com.rk.repository.StaffRepository;
import com.rk.service.MaintenanceService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;
    @Autowired
    StaffRepository staffRepository;

    public List<MaintenanceRequest> getAllRequests() {
        return maintenanceRepository.findAll();
    }

    public Optional<MaintenanceRequest> getRequestById(Long id) {
        return maintenanceRepository.findById(id);
    }
    public MaintenanceRequest createRequest(MaintenanceRequest request) {
        // Ensure that the technicianAssigned is fetched correctly
    	request.setCreatedAt(LocalDateTime.now());
        request.setUpdatedAt(LocalDateTime.now());
        if (request.getTechnicianAssigned() != null && request.getTechnicianAssigned().getId() != null) {
            Staff technician = staffRepository.findById(request.getTechnicianAssigned().getId()).orElse(null);
            request.setTechnicianAssigned(technician);
        }
        return maintenanceRepository.save(request);
    }

   

    public MaintenanceRequest updateRequest(Long id, MaintenanceRequest request) {
        if (maintenanceRepository.existsById(id)) {
            request.setId(id);
            request.setUpdatedAt(LocalDateTime.now());
            return maintenanceRepository.save(request);
        }
        return null;
    }

    public void deleteRequest(Long id) {
        maintenanceRepository.deleteById(id);
    }

    public List<MaintenanceRequest> getRequestsByRoom(Long roomId) {
        return maintenanceRepository.findByRoomId(roomId);
    }

    public List<MaintenanceRequest> getRequestsByTechnician(Long technicianId) {
        return maintenanceRepository.findByTechnicianAssigned_Id(technicianId);
    }
}
