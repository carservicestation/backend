package com.app.service;

import java.util.List;

import com.app.pojos.ServiceCenter;

public interface IServiceCenterService {
	
	Integer addServiceCenter(ServiceCenter sc);

	void removeServiceCenter(int scid);

	ServiceCenter getServiceCenterById(int scid);

	void updateServiceCenter(ServiceCenter sc);
	
	ServiceCenter getServiceCentersByOwnerId(int oid);

	List<ServiceCenter> getServiceCenters();

}
