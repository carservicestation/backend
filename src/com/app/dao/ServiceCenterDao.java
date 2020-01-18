package com.app.dao;

import java.util.List;

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
	public Integer addServiceCenter(ServiceCenter sc) {
		return (Integer) sf.getCurrentSession().save(sc);
	}

	@Override
	public ServiceCenter getServiceCenterById(int scid) {
		return sf.getCurrentSession().get(ServiceCenter.class, scid);
	}

	@Override
	public void updateServiceCenter(ServiceCenter sc) {
		sf.getCurrentSession().update(sc);
	}

	@Override
	public void removeServiceCenter(int scid) {
		ServiceCenter sc = sf.getCurrentSession().get(ServiceCenter.class, scid);
		sf.getCurrentSession().remove(sc);
	}

	@Override
	public List<ServiceCenter> getServiceCenters() {
		/* service centers list for admin */
		String jpql = "select sc from ServiceCenter sc";
		return (List<ServiceCenter>) sf.getCurrentSession().createQuery(jpql, ServiceCenter.class).getResultList();
	}
}
