package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAppointmentDao;
import com.app.pojos.Appointment;

@Service
@Transactional
public class AppointmentService implements IAppointmentService {

	@Autowired
	private IAppointmentDao dao;
	
	@Override
	public Integer addAppointment(Appointment a) {
		return dao.addAppointment(a);
	}

	@Override
	public Appointment getAppointmentById(int apid) {
		return dao.getAppointmentById(apid);
	}

	@Override
	public List<Appointment> getAppointments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelAppointment(int apid) {
		// TODO Auto-generated method stub
	}

}
