package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.pojos.ServiceCenter;
import com.app.pojos.Services;

public interface IServiceCenterService {
	
	Integer addServiceCenter(ServiceCenter sc);

	void removeServiceCenter(int scid);

	Set<Services> getServiceCenterById(int scid);

	void updateServiceCenter(ServiceCenter sc);
	
	ServiceCenter getServiceCentersByOwnerId(int oid);

	List<ServiceCenter> getServiceCenters();

	List<ServiceCenter> GetServiceCentersNearCustomer(Integer cid);

}
