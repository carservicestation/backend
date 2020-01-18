package com.app.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Service;
import com.app.pojos.ServiceCenter;

@Repository
@Transactional
public class ServiceDao implements IServiceDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Integer addService(Service s) {
		return (Integer) sf.getCurrentSession().save(s);
	}

	@Override
	public Service getServiceById(int sid) {
		return sf.getCurrentSession().get(Service.class, sid);
	}

	@Override
	public void updateService(Service s) {
		sf.getCurrentSession().update(s);
	}

	@Override
	public void removeService(int sid) {
		Service s = sf.getCurrentSession().get(Service.class, sid);
		sf.getCurrentSession().remove(s);
	}

	@Override
	public List<Service> getServices() {
		/* services list for admin */
		String jpql = "select s from Service s";
		return (List<Service>) sf.getCurrentSession().createQuery(jpql, Service.class).getResultList();
	}

	@Override
	public Set<Service> getServicesByServiceCenter(int scid) {
		ServiceCenter sc = sf.getCurrentSession().get(ServiceCenter.class, scid);
		sc.getServices().size();
		return sc.getServices();
	}

}
