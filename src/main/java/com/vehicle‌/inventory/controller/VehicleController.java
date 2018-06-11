package com.vehicle‌.inventory.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.inventory.model.Vehicle;
import com.vehicle.inventory.service.VehicleService;


@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	final static Logger logger = Logger.getLogger(VehicleController.class);

	@Autowired
	VehicleService vehicleService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
		vehicleService.save(vehicle);
		logger.debug("Added:: " + vehicle);
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.CREATED);
	}


	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateVehicle(@RequestBody Vehicle vehicle) {
		Vehicle existingVehicle = vehicleService.getById(vehicle.getId());
		if (existingVehicle == null) {
			logger.debug("Vehile with id " + vehicle.getId() + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			vehicleService.save(vehicle);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") Long id) {
		Vehicle vehicle = vehicleService.getById(id);
		if (vehicle == null) {
			logger.debug("Vehicle with id " + id + " does not exists");
			return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Vehicle:: " + vehicle);
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/byType/{type}", method = RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> getVehiclebyType(@PathVariable("type") String type) {
		List<Vehicle> vehicles = vehicleService.getType(type);
		if (vehicles == null || vehicles.isEmpty()) {
			logger.debug("Vehicles with type " + type + " does not exists");
			return new ResponseEntity<List<Vehicle>>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Vehicles:: " + vehicles);
		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	} 

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> getAllVehicle() {
		List<Vehicle> vehicles = vehicleService.getAll();
		if (vehicles.isEmpty()) {
			logger.debug("Vehicles does not exists");
			return new ResponseEntity<List<Vehicle>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + vehicles.size() + " Vehicles");
		logger.debug(Arrays.toString(vehicles.toArray()));
		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteVehicle(@PathVariable("id") Long id) {
		Vehicle vehicle = vehicleService.getById(id);
		if (vehicle == null) {
			logger.debug("Vehicle with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			vehicleService.delete(id);
			logger.debug("Vehicle with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
