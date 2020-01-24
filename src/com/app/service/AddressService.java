package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAddressDao;
import com.app.pojos.Address;

@Service
@Transactional
public class AddressService implements IAddressService {
	
	@Autowired
	private IAddressDao dao;

	@Override
	public void addOrUpdateOwnerAddress(int oid, Address oa) {
		dao.addOrUpdateOwnerAddress(oid, oa);
	}

	@Override
	public Address getOwnerAddressByOwnerId(int oid) {
		return dao.getOwnerAddressByOwnerId(oid);
	}

	@Override
	public void removeOwnerAddress(int oid) {
		dao.removeOwnerAddress(oid);

	}

	@Override
	public void addOrUpdateServiceCenterAddress(int scid, Address sca) {
		dao.addOrUpdateServiceCenterAddress(scid, sca);

	}

	@Override
	public Address getServiceCenterAddressByServiceCenterId(int scid) {
		return dao.getServiceCenterAddressByServiceCenterId(scid);
	}

	@Override
	public void removeServiceCenterAddress(int scid) {
		dao.removeServiceCenterAddress(scid);
	}

	@Override
	public void removeCustomerAddress(int cid, int caid) {
		dao.removeCustomerAddress(cid, caid);
	}

	@Override
	public void addCustomerAddress(int cid, Address ca) {
		dao.addCustomerAddress(cid, ca);
	}

	@Override
	public Address getAddressByAddressId(int aid) {
		return dao.getAddressByAddressId(aid);
	}

	@Override
	public List<Address> getCustomerAddressesByCustomerId(int cid) {
		return dao.getCustomerAddressesByCustomerId(cid);
	}

}
