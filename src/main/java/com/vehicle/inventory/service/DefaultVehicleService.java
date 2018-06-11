package com.vehicle.inventory.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.inventory.model.Vehicle;
import com.vehicle.inventory.repository.VehicleRepository;

@Service
public class DefaultVehicleService implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle save(Vehicle entity) {
		return vehicleRepository.save(entity);
	}

	@Override
	public Vehicle getById(Serializable id) {
		return vehicleRepository.findOne((Long) id);
	}

	@Override
	public List<Vehicle> getAll() {
		return vehicleRepository.findAll();
	}

	@Override
	public void delete(Serializable id) {
		vehicleRepository.delete((Long) id);
	}

	@Override
	public List<Vehicle> getType(String type) {
		return vehicleRepository.getVehicleDetailsByType(type);
	}

}
