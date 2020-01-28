package com.app.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAppointmentDao;
import com.app.pojos.Appointment;
import com.app.pojos.Services;
import com.app.pojos.Status;

@Service
@Transactional
public class AppointmentService implements IAppointmentService {

	@Autowired
	private IAppointmentDao dao;
	
	//---------------------------------------------------------------------------------------------
	//Customer
	@Override
	public Integer addAppointment(Appointment a) {
		return dao.addAppointment(a);
	}


	@Override
	public List<Appointment> getCustomerAppointments(Integer cid) {
		return dao.getCustomerAppointments(cid);
	}


	@Override
	public Status cancelAppointment(int apid) {
		return dao.cancelAppointment(apid);
	}
	//---------------------------------------------------------------------------------------------
	//Serv Center
	
	@Override
	public List<Appointment> getServiceCenterAppointments(Integer oid) {
		return dao.getServiceCenterAppointments(oid);
	}

	@Override
	public Status acceptAppointment(Integer apid) {
		return dao.acceptAppointment(apid);	
	}

	//---------------------------------------------------------------------------------------------

	@Override
	public Set<Services> getServicesByAppointmentById(Integer apid) {
		return dao.getServicesByAppointmentById(apid);
	}

	@Override
	public Appointment getAppointmentById(int apid) {
		return dao.getAppointmentById(apid);
	}

	@Override
	public List<Appointment> getAppointments() {
		return dao.getAppointments();
	}
}
