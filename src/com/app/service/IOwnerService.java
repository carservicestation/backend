package com.app.service;

import java.util.List;

import com.app.pojos.Customer;
import com.app.pojos.Owner;
import com.app.pojos.ServiceCenter;

public interface IOwnerService {


	Owner addOwner(Owner o);

	Owner getOwnerById(int oid);

	void updateOwner(Owner o);

	void removeOwner(int oid);

	List<Owner> getAllOwners();

	List<ServiceCenter> getServiceCentersByOwner(int oid);

}
