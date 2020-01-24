package com.app.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;

@Repository
@Transactional
public class ServiceDao implements IServiceDao {


	@Autowired
	private SessionFactory sf;

	@Override
	public Integer addService(Services s) {
		return (Integer) sf.getCurrentSession().save(s);
	}

	
	@Override
	public Services getServiceById(int sid) {
		return sf.getCurrentSession().get(Services.class, sid);
	}

	@Override
	public void updateService(Services s) {
		sf.getCurrentSession().update(s);
	}

	@Override
	public void removeService(int sid) {
		Services s = sf.getCurrentSession().get(Services.class, sid);
		sf.getCurrentSession().remove(s);
	}

	@Override
	public List<Services> getServices() {
		/* services list for admin */
		
		String jpql = "select s from Services s";
		return (List<Services>) sf.getCurrentSession().createQuery(jpql, Services.class).getResultList();
	}

	
	@Override
	public Set<Services> getServicesByServiceCenterId(int scid) {
		ServiceCenter sc = sf.getCurrentSession().get(ServiceCenter.class, scid);
		sc.getServices().size();
		return sc.getServices();
	}
	
	@Override
	public Set<Services> getServicesByAppointmentId(int apid) {
		Appointment ap = sf.getCurrentSession().get(Appointment.class, apid);
		ap.getServices().size();
		return ap.getServices();
	}


}
