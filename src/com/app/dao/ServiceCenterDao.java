package com.app.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;

@Repository
public class ServiceCenterDao implements IServiceCenterDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Integer addServiceCenter(ServiceCenter sc) {
		// Owner o = sf.getCurrentSession().get(Owner.class,sc.getOwner().getId());
		Owner o = sc.getOwner();
		o.setServiceCenter(sc);
		sc.setWallet(50000);
		// sf.getCurrentSession().update(o);
		return (Integer) sf.getCurrentSession().save(sc);
	}

	@Override
	public Set<Services> getServiceCenterById(int scid) {
		ServiceCenter sc = sf.getCurrentSession().get(ServiceCenter.class, scid);
		sc.getServices().size();
		return sc.getServices();
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
	public ServiceCenter getServiceCenterByOwnerId(int oid) {

		Owner o = sf.getCurrentSession().get(Owner.class, oid);
		return o.getServiceCenter();
	}

	@Override
	public List<ServiceCenter> getServiceCenters() {
		Session session = sf.getCurrentSession();
		Criteria cr = session.createCriteria(ServiceCenter.class)
				.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
						.add(Projections.property("name"), "name").add(Projections.property("email"), "email")
						.add(Projections.property("wallet"), "wallet").add(Projections.property("phone"), "phone"))
				.setResultTransformer(Transformers.aliasToBean(ServiceCenter.class));
		List<ServiceCenter> ssl = cr.list();
		// String jpql = "select sc.id, sc.name, sc.email, sc.phone from ServiceCenter
		// sc";
		// List<ServiceCenter> list = (List<ServiceCenter>)
		// sf.getCurrentSession().createQuery(jpql).getResultList();
		return ssl;
	}

	@Override
	public List<ServiceCenter> GetServiceCentersNearCustomer(Integer cid) {
		List<ServiceCenter> scl = null;
		Address a = null;
		Session session = sf.getCurrentSession();
		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		String pincust = c.getAddress().getPincode();
		String jpql1 = "Select distinct sc from ServiceCenter sc join fetch sc.address join fetch sc.services where sc.address.pincode=:pin";
		scl = sf.getCurrentSession().createQuery(jpql1, ServiceCenter.class).setParameter("pin", pincust)
				.getResultList();
		return scl;

		// address servicecenter
		/*
		 * String jpql =
		 * "select c from Course c left outer join fetch c.students where c.name=:nm";
		 * 
		 * Criteria cr = session.createCriteria(ServiceCenter.class).setProjection(
		 * 
		 * Projections.projectionList()
		 * 
		 * .add(Projections.property("id"), "id").add(Projections.property("name"),
		 * "name") .add(Projections.property("email"),
		 * "email").add(Projections.property("wallet"), "wallet")
		 * .add(Projections.property("phone"), "phone"))
		 * 
		 * .add(Restrictions.eq("studentId", 1))
		 * .setResultTransformer(Transformers.aliasToBean(ServiceCenter.class));
		 * 
		 * List<ServiceCenter> ssl = cr.list();
		 * 
		 * return ssl;
		 */
	}
}
