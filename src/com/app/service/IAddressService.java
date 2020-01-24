package com.app.service;

import java.util.List;

import com.app.pojos.Address;

public interface IAddressService {
	
	void addOrUpdateOwnerAddress(int oid, Address oa);

	Address getOwnerAddressByOwnerId(int oid);

	void removeOwnerAddress(int oid);

	void addOrUpdateServiceCenterAddress(int scid, Address sca);

	Address getServiceCenterAddressByServiceCenterId(int scid);

	void removeServiceCenterAddress(int scid);

	void removeCustomerAddress(int cid, int caid);

	List<Address> getCustomerAddressesByCustomerId(int cid);

	Address getAddressByAddressId(int aid);

	void addCustomerAddress(int cid, Address ca);

}
