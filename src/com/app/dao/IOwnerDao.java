package com.app.dao;

import com.app.pojos.*;

public interface IOwnerDao {
	
	Integer addOwner(Owner o);

	void addOwnerAddress(int oid, OwnerAddress oa);

	void removeOwnerAddress(int oid, int oaid);

	Owner getOwner(int oid);
	
	
	

}
