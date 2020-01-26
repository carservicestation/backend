package com.app.dao;

import java.util.List;

import com.app.pojos.ServiceCenter;

public interface IServiceCenterDao {

	Integer addServiceCenter(ServiceCenter sc);

	void removeServiceCenter(int scid);

	ServiceCenter getServiceCenterById(int scid);

	void updateServiceCenter(ServiceCenter sc);

	List<ServiceCenter> getServiceCenters();

	ServiceCenter getServiceCenterByOwnerId(int oid);

}
