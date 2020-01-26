package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;

@Repository
public class OwnerDao implements IOwnerDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Owner addOwner(Owner o) {
		o.setRole(Role.OWNER);
		sf.getCurrentSession().save(o);
		return o;
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
		String jpql = "select o from Owner o";
		return (List<Owner>) sf.getCurrentSession().createQuery(jpql, Owner.class).getResultList();
	}
}
