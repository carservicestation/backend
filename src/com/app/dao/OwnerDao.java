package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;

@Repository
@Transactional
public class OwnerDao implements IOwnerDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Integer addOwner(Owner o) {
		Integer goid = (Integer) sf.getCurrentSession().save(o);
		System.out.println("cid" + goid);
		User u = new User();
		u.setEmail(o.getEmail());
		u.setPassword(o.getPassword());
		u.setRole(Role.CUSTOMER);
		u.setOwner(o);
		Integer guid = (Integer) sf.getCurrentSession().save(u);
		System.out.println("guid" + guid);
		return goid;
	}

	@Override
	public Owner getOwnerById(int oid) {
		return sf.getCurrentSession().get(Owner.class, oid);
	}

	@Override
	public void updateOwner(Owner o) {
		sf.getCurrentSession().update(o);
	}

	@Override
	public void removeOwner(int oid) {
		Owner o = sf.getCurrentSession().get(Owner.class, oid);
		sf.getCurrentSession().remove(o);
	}

	@Override
	public List<Owner> getAllOwners() {
		/* owners list for admin */
		String jpql = "select o from Owner o";
		return (List<Owner>) sf.getCurrentSession().createQuery(jpql, Owner.class).getResultList();
	}

	@Override
	public void addOrUpdateOwnerAddress(int oid, Address oa) {
		Owner o = sf.getCurrentSession().get(Owner.class, oid);
		o.setAddress(oa);
		sf.getCurrentSession().update(o);
	}

	@Override
	public Address getOwnerAddressByOwnerId(int oid) {
		Owner o = sf.getCurrentSession().get(Owner.class, oid);
		return o.getAddress();
	}
	
	@Override
	public void removeOwnerAddress(int oid) {
		Owner o = sf.getCurrentSession().get(Owner.class, oid);
		o.setAddress(null);
		sf.getCurrentSession().update(o);
	}
		
	@Override
	public List<ServiceCenter> getServiceCentersByOwner(int oid) {
		/* list of service centers owned by owner */
		Owner o = sf.getCurrentSession().get(Owner.class, oid);
		o.getServiceCenters().size();
		return o.getServiceCenters();
	}


}
