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
public class ServiceCenterDao implements IServiceCenterDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Integer addService(Service s) {

		return (Integer) sf.getCurrentSession().save(s);
	}

	@Override
	public List<ServiceCenter> getServiceCenters() {
		String jpql = "select sc from ServiceCenter sc";
		return (List<ServiceCenter>) sf.getCurrentSession().createQuery(jpql, ServiceCenter.class).getResultList();
	}

	@Override
	public List<ServiceCenter> getServiceCentersByOwner(int oid) {
		Owner o = sf.getCurrentSession().get(Owner.class, oid);

		o.getServiceCenters().size();

		return o.getServiceCenters();
	}

	@Override
	public Set<Service> getServicesByServiceCenter(int scid) {
		ServiceCenter sc = sf.getCurrentSession().get(ServiceCenter.class, scid);

		sc.getServices().size();

		return sc.getServices();
	}
	
	@Override
	public Integer addServiceCenter(ServiceCenter sc) 
	{
		return (Integer) sf.getCurrentSession().save(sc);
	}

	@Override
	public void removeService(int sid) {

		Service s = sf.getCurrentSession().get(Service.class, sid);
		
		sf.getCurrentSession().remove(s);
	}
	
	@Override
	public void removeServiceCenter(int scid) 
	{
		ServiceCenter sc = sf.getCurrentSession().get(ServiceCenter.class, scid);
		
		sf.getCurrentSession().remove(sc);
	}
	
}

















