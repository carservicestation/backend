package com.app.dao;

import java.util.List;

import com.app.pojos.*;

public interface IOwnerDao {
	
	Integer addOwner(Owner o);

	void addOwnerAddress(int oid, OwnerAddress oa);

	void removeOwnerAddress(int oid, int oaid);

	Owner getOwner(int oid);

	List<Owner> getAllOwners();
	
	
	

}
