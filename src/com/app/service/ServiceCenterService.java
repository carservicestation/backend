package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IServiceCenterDao;
import com.app.pojos.ServiceCenter;

@Service 
@Transactional
public class ServiceCenterService implements IServiceCenterService {
	
	@Autowired
	private IServiceCenterDao dao;

	@Override
	public Integer addServiceCenter(ServiceCenter sc) {
		
		return dao.addServiceCenter(sc);
	}

	@Override
	public void removeServiceCenter(int scid) {
		dao.removeServiceCenter(scid);

	}

	@Override
	public ServiceCenter getServiceCenterById(int scid) {
		return dao.getServiceCenterById(scid);
	}

	@Override
	public void updateServiceCenter(ServiceCenter sc) {
		dao.updateServiceCenter(sc);
	}

	@Override
	public List<ServiceCenter> getServiceCenters() {
		return dao.getServiceCenters();
	}

	@Override
	public ServiceCenter getServiceCentersByOwnerId(int oid) {
		return dao.getServiceCenterByOwnerId(oid);
	}

}
