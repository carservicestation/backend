package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.*;

@Repository
public class AddressDao implements IAddressDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Address getAddressByAddressId(int aid) {
		return sf.getCurrentSession().get(Address.class, aid);
	}

	@Override
	public void removeAddressByAddressId(int aid) {
		Address a = sf.getCurrentSession().get(Address.class, aid);
		sf.getCurrentSession().remove(a);
	}

	// ----------------------------------------------------------------------------------------------
	// ServiceCenterAddress
	// ----------------------------------------------------------------------------------------------
	@Override
	public Address getServiceCenterAddressByServiceCenterId(int scid) {
		ServiceCenter sc = sf.getCurrentSession().get(ServiceCenter.class, scid);
		return sc.getAddress();
	}

	@Override
	public void addOrUpdateServiceCenterAddress(int scid, Address sca) {
		ServiceCenter sc = sf.getCurrentSession().get(ServiceCenter.class, scid);
		sc.setAddress(sca);
		sf.getCurrentSession().update(sc);
	}

	@Override
	public void removeServiceCenterAddress(int scid) {
		ServiceCenter sc = sf.getCurrentSession().get(ServiceCenter.class, scid);
		sc.setAddress(null);
		sf.getCurrentSession().update(sc);
	}

	// ----------------------------------------------------------------------------------------------
	// CustomerAddress
	// ----------------------------------------------------------------------------------------------

	@Override
	public void addCustomerAddress(Integer cid, Address ca) {
		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		c.setAddress(ca);
		sf.getCurrentSession().update(c);
	}

	@Override
	public Address getCustomerAddressesByCustomerId(int cid) {
		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		return c.getAddress();
	}

	@Override
	public void removeCustomerAddress(int cid) {
		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		c.setAddress(null);
		sf.getCurrentSession().update(c);
	}

}
