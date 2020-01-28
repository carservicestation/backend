package com.app.dao;

import java.util.List;
import java.util.Set;

import com.app.pojos.*;


public interface IAppointmentDao {
	
	Integer addAppointment(Appointment a);
	
	Status cancelAppointment(int apid);

	Status acceptAppointment(Integer apid);
	
	List<Appointment> getCustomerAppointments(Integer cid);

	
	List<Appointment> getServiceCenterAppointments(Integer oid);

		
	Set<Services> getServicesByAppointmentById(Integer apid);
	
	Appointment getAppointmentById(int apid);
	
	List<Appointment> getAppointments();

	
//	Address selectPickupAddress();
	
//	Vehicle selectVehicle();
	
//	Set<Service> selectServices();

}
