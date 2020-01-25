package com.app.service;

import java.util.List;

import com.app.pojos.Vehicle;

public interface IVehicleService {

	Integer addVehicle(Vehicle v);

	Vehicle getVehicleById(int vid);

	void updateVehicle(Vehicle v);

	List<Vehicle> getVehicles();

	void removeVehicle(int vid);

	List<String> getDistinctVehicleMakes();

}
