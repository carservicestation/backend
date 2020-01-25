package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVehicleDao;
import com.app.pojos.Vehicle;

@Service
@Transactional
public class VehicleService implements IVehicleService {
	
	@Autowired
	private IVehicleDao dao;

	@Override
	public Integer addVehicle(Vehicle v) {
		return dao.addVehicle(v);
	}

	@Override
	public Vehicle getVehicleById(int vid) {
		return dao.getVehicleById(vid);
	}

	@Override
	public void updateVehicle(Vehicle v) {
		dao.updateVehicle(v);
	}

	@Override
	public List<Vehicle> getVehicles() {
		return dao.getVehicles();
	}

	@Override
	public void removeVehicle(int vid) {
		dao.removeVehicle(vid);
	}

	@Override
	public List<String> getDistinctVehicleMakes() {
		return dao.getDistinctVehicleMakes();
	}

}
