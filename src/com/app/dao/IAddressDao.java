package com.app.dao;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.Customer;

public interface IAddressDao {

	void addOrUpdateOwnerAddress(int oid, Address oa);

	Address getOwnerAddressByOwnerId(int oid);

	void removeOwnerAddress(int oid);

	void addOrUpdateServiceCenterAddress(int scid, Address sca);

	Address getServiceCenterAddressByServiceCenterId(int scid);

	void removeServiceCenterAddress(int scid);

	void removeCustomerAddress(int cid, int caid);

	void addOrUpdateCustomerAddress(int cid, Address ca);

	Address getCustomerAddressByAddressId(int caid);

	List<Address> getCustomerAddressesByCustomerId(int cid);

	Address getAddressByAddressId(int aid);
}
