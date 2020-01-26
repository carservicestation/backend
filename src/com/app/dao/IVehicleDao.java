package com.app.dao;

import java.util.List;

import com.app.pojos.Vehicle;

public interface IVehicleDao {

	
	Integer addVehicle(Vehicle v);
	
	Vehicle getVehicleById(int vid);

	void updateVehicle(Vehicle v);

	List<Vehicle> getVehicles();

	void removeVehicle(int vid);

	List<String> getDistinctVehicleMakes();

	List<String> getModelsByVehicleMakes(String make);

	

}
