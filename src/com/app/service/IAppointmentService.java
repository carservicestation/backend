package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.pojos.Appointment;
import com.app.pojos.Services;
import com.app.pojos.Status;

public interface IAppointmentService {

Integer addAppointment(Appointment a);
	
	Status cancelAppointment(int apid);

	Status acceptAppointment(Integer apid);
	
	List<Appointment> getCustomerAppointments(Integer cid);

	
	List<Appointment> getServiceCenterAppointments(Integer oid);

		
	Set<Services> getServicesByAppointmentById(Integer apid);
	
	Appointment getAppointmentById(int apid);
	
	List<Appointment> getAllAppointments();
	
}
