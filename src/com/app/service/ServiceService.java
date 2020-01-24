package com.app.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IServiceDao;
import com.app.pojos.*;

@Service
@Transactional
public class ServiceService implements IServiceService {
	
	@Autowired
	private IServiceDao dao;

	@Override
	public Services getServiceById(int sid) {
		return dao.getServiceById(sid);
	}

	@Override
	public void updateService(Services s) {
		dao.updateService(s);
	}

	@Override
	public Integer addService(Services s) {
		return dao.addService(s);
	}

	@Override
	public void removeService(int sid) {
		dao.removeService(sid);
	}

	@Override
	public List<Services> getServices() {
		return dao.getServices();
	}

	@Override
	public Set<Services> getServicesByServiceCenterId(int scid) {
		return dao.getServicesByServiceCenterId(scid);
	}

	@Override
	public Set<Services> getServicesByAppointmentId(int apid) {
		return dao.getServicesByAppointmentId(apid);
	}

}
