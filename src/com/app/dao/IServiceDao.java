package com.app.dao;

import java.util.List;
import java.util.Set;

import com.app.pojos.Service;

public interface IServiceDao {

	Service getServiceById(int sid);

	void updateService(Service s);
	
	Integer addService(Service s);

	Set<Service> getServicesByServiceCenter(int scid);

	void removeService(int sid);

	List<Service> getServices();
	
}
