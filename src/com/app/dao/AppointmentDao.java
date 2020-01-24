package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Appointment;

@Repository
public class AppointmentDao implements IAppointmentDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Integer addAppointment(Appointment a) {
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
