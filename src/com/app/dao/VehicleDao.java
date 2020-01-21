package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Vehicle;

@Repository
@Transactional
public class VehicleDao implements IVehicleDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Integer addVehicle(Vehicle v) {
		return (Integer) sf.getCurrentSession().save(v);
	}

	@Override
	public Vehicle getVehicleById(int vid) {
		return sf.getCurrentSession().get(Vehicle.class, vid);
	}

	@Override
	public void updateVehicle(Vehicle v) {
		sf.getCurrentSession().update(v);
	}

	@Override
	public void removeVehicle(int vid) {

		Vehicle v = sf.getCurrentSession().get(Vehicle.class, vid);
		sf.getCurrentSession().remove(v);
	}

	@Override
	public List<Vehicle> getVehicles() {
		/* Vehicle list for admin */
		String jpql = "select v from Vehicle v";
		return (List<Vehicle>) sf.getCurrentSession().createQuery(jpql, Vehicle.class).getResultList();
	}
}
