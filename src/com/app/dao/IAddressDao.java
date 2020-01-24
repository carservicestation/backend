package com.app.dao;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.Customer;

public interface IAddressDao {

	Address getAddressByAddressId(int aid);
	
	void removeAddressByAddressId(int aid);

	
	
	
	void addOrUpdateOwnerAddress(int oid, Address oa);

	Address getOwnerAddressByOwnerId(int oid);

	void removeOwnerAddress(int oid);

	void addOrUpdateServiceCenterAddress(int scid, Address sca);

	Address getServiceCenterAddressByServiceCenterId(int scid);

	void removeServiceCenterAddress(int scid);

	void removeCustomerAddress(int cid, int caid);

	List<Address> getCustomerAddressesByCustomerId(int cid);


	void addCustomerAddress(Integer cid, Address ca);




}
