package com.rk.service;

import java.util.List;
import java.util.Optional;

import com.rk.entity.MaintenanceRequest;

public interface MaintenanceService {

	List<MaintenanceRequest> getAllRequests();

	Optional<MaintenanceRequest> getRequestById(Long id);

	MaintenanceRequest createRequest(MaintenanceRequest request);

	MaintenanceRequest updateRequest(Long id, MaintenanceRequest request);

	void deleteRequest(Long id);

	List<MaintenanceRequest> getRequestsByRoom(Long roomId);

	List<MaintenanceRequest> getRequestsByTechnician(Long technicianId);

}
