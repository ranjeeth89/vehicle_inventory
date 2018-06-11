package com.vehicle.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vehicle.inventory.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	@Query(value = "SELECT * FROM VEHICLE WHERE TYPE = ?1", nativeQuery = true)
	List<Vehicle> getVehicleDetailsByType(String type);

}
