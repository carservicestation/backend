package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;

@Repository
@Transactional
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
	
	//----------------------------------------------------------------------------------------------
	//OwnerAddress
	//----------------------------------------------------------------------------------------------

	@Override
	public Address getOwnerAddressByOwnerId(int oid) {
		Owner o = sf.getCurrentSession().get(Owner.class, oid);
		return o.getAddress();
	}
	
	@Override
	public void addOrUpdateOwnerAddress(int oid, Address oa) {
		Owner o = sf.getCurrentSession().get(Owner.class, oid);
		o.addAddress(oa);
		sf.getCurrentSession().update(o);
	}
	
	@Override
	public void removeOwnerAddress(int oid) {
		Owner o = sf.getCurrentSession().get(Owner.class, oid);
		o.removeAddress();
		sf.getCurrentSession().update(o);
	}
	
	
	//----------------------------------------------------------------------------------------------
	//ServiceCenterAddress
	//----------------------------------------------------------------------------------------------
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
	
	//----------------------------------------------------------------------------------------------
	//CustomerAddress
	//----------------------------------------------------------------------------------------------
	
	@Override
	public void addCustomerAddress(Integer cid, Address ca) {
		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		c.addAddress(ca);
		sf.getCurrentSession().update(c);
	}
	
	@Override
	public List<Address> getCustomerAddressesByCustomerId(int cid) {
		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		c.getAddresses().size();
		return c.getAddresses();
	}

	@Override
	public void removeCustomerAddress(int cid, int caid) {
		Customer c = sf.getCurrentSession().get(Customer.class, cid);
		Address ca = sf.getCurrentSession().get(Address.class, caid);
		c.getAddresses().size();
		c.removeAddress(ca);
		sf.getCurrentSession().update(c);
	}



}
