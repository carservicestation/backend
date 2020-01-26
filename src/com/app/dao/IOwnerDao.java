package com.app.dao;

import java.util.List;

import com.app.pojos.*;

public interface IOwnerDao {

	Owner addOwner(Owner o);

	Owner getOwnerById(int oid);

	void updateOwner(Owner o);

	void removeOwner(int oid);

	List<Owner> getAllOwners();
	
}
