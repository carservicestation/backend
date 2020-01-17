package com.app.dao;

import java.util.List;
import java.util.Set;

import com.app.pojos.Service;
import com.app.pojos.ServiceCenter;

public interface IServiceCenterDao {
	
	Integer addService(Service s);

	List<ServiceCenter> getServiceCenters();

	Set<Service> getServicesByServiceCenter(int scid);

	Integer addServiceCenter(ServiceCenter sc);

	void removeServiceCenter(int scid);

	void removeService(int sid);

	List<ServiceCenter> getServiceCentersByOwner(int oid);

}
