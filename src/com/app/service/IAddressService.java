package com.app.service;

import com.app.pojos.Address;

public interface IAddressService {
	
	void addOrUpdateServiceCenterAddress(int scid, Address sca);

	Address getServiceCenterAddressByServiceCenterId(int scid);

	void removeServiceCenterAddress(int scid);

	void removeCustomerAddress(int cid);

	Address getCustomerAddressesByCustomerId(int cid);

	Address getAddressByAddressId(int aid);

	void addCustomerAddress(int cid, Address ca);

}
