package com.app.dao;

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
		System.out.println("cid"+goid);

		User u = new User();
		u.setEmail(o.getEmail());
		u.setPassword(o.getPassword());
		u.setRole(Role.CUSTOMER);
		u.setOwner(o);

		Integer guid = (Integer) sf.getCurrentSession().save(u);

		System.out.println("guid"+guid);
		return goid;

	}
	
	@Override
	public Owner getOwner(int oid)
	{
		return sf.getCurrentSession().get(Owner.class, oid);
	}

	@Override
	public void addOwnerAddress(int oid, OwnerAddress oa) {
		Owner o = sf.getCurrentSession().get(Owner.class, oid);

		o.setAddress(oa);

		sf.getCurrentSession().update(o);		
	}

	@Override
	public void removeOwnerAddress(int oid, int oaid) {
		Owner o = sf.getCurrentSession().get(Owner.class, oid);

		OwnerAddress oa = sf.getCurrentSession().get(OwnerAddress.class, oaid);
		
		o.setAddress(oa);

		sf.getCurrentSession().update(o);		
	}


}
