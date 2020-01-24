package com.app.dao;

import java.util.List;
import com.app.pojos.*;


public interface IAppointmentDao {
	
	Integer addAppointment(Appointment a);
	
	Appointment getAppointmentById(int apid);
	
	List<Appointment> getAppointments();

	void cancelAppointment(int apid);
	
//	Address selectPickupAddress();
	
//	Vehicle selectVehicle();
	
//	Set<Service> selectServices();

}
