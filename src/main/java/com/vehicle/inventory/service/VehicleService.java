package com.vehicle.inventory.service;

import java.util.List;

import com.vehicle.inventory.model.Vehicle;

public interface VehicleService extends CRUDService<Vehicle> {
	List<Vehicle> getType(String type);
}
