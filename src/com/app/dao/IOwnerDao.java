package com.app.dao;

import java.util.List;

import com.app.pojos.*;

public interface IOwnerDao {

	Integer addOwner(Owner o);

	Owner getOwnerById(int oid);

	void updateOwner(Owner o);

	void removeOwner(int oid);

	List<Owner> getAllOwners();

	List<ServiceCenter> getServiceCentersByOwner(int oid);

	void removeOwnerAddress(int oid);

	void addOrUpdateOwnerAddress(int oid, Address oa);

	Address getOwnerAddressByOwnerId(int oid);

}
