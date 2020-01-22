package com.app.dao;

import java.util.List;
import java.util.Set;

import com.app.pojos.Service;

public interface IServiceDao {

	Service getServiceById(int sid);

	void updateService(Service s);
	
	Integer addService(Service s);

	void removeService(int sid);

	List<Service> getServices();

	Set<Service> getServicesByServiceCenterId(int scid);

	Set<Service> getServicesByAppointmentId(int apid);
	
}
