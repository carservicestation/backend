package com.app.dao;

import java.util.List;
import java.util.Set;

import com.app.pojos.ServiceCenter;
import com.app.pojos.Services;

public interface IServiceCenterDao {

	Integer addServiceCenter(ServiceCenter sc);

	void removeServiceCenter(int scid);

	Set<Services> getServiceCenterById(int scid);

	void updateServiceCenter(ServiceCenter sc);

	List<ServiceCenter> getServiceCenters();

	ServiceCenter getServiceCenterByOwnerId(int oid);

	List<ServiceCenter> GetServiceCentersNearCustomer(Integer cid);

}
