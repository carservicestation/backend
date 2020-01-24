package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.pojos.Services;

public interface IServiceService {
	
	Services getServiceById(int sid);

	void updateService(Services s);
	
	Integer addService(Services s);

	void removeService(int sid);

	List<Services> getServices();

	Set<Services> getServicesByServiceCenterId(int scid);

	Set<Services> getServicesByAppointmentId(int apid);

}
