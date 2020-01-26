package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Appointment;
import com.app.pojos.Vehicle;

@Repository
public class AppointmentDao implements IAppointmentDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Integer addAppointment(Appointment a) {
		
		Session s = sf.getCurrentSession();
		
		Vehicle uv = a.getVehicle();
		
		String jpql = "Select v from Vehicle v where v.make=:m and v.model=:mm and v.fuelType=:f";
		
		 Vehicle v = s.createQuery(jpql, Vehicle.class)
				 .setParameter("m", uv.getMake())
				 .setParameter("mm", uv.getModel())
				 .setParameter("f", uv.getFuelType())
				 .getSingleResult();
		
		 a.setVehicle(v);
		
		return (Integer) sf.getCurrentSession().save(a);
	}

	@Override
	public Appointment getAppointmentById(int apid) {
		return sf.getCurrentSession().get(Appointment.class, apid);
	}

	@Override
	public List<Appointment> getAppointments() {
		return null;
	}

	@Override
	public void cancelAppointment(int apid) {

	}

}
