package com.app.service;

import java.util.List;

import com.app.pojos.Appointment;

public interface IAppointmentService {

	Integer addAppointment(Appointment a);

	Appointment getAppointmentById(int apid);

	List<Appointment> getAppointments();

	void cancelAppointment(int apid);

}
