package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.*;
import com.app.pojos.Customer;
import com.app.pojos.Owner;
import com.app.pojos.Role;
import com.app.pojos.ServiceCenter;
import com.app.pojos.User;

@Service
@Transactional
public class OwnerService implements IOwnerService {
	
	@Autowired
	private IOwnerDao odao;

	@Autowired
	private IUserDao udao;
	
	@Override
	public Owner addOwner(Owner o)
	{
		User u = new User(o.getEmail(), o.getPassword(), Role.OWNER);
		System.out.println("os");
		System.out.println(u);
		User dbu = udao.addUser(u);
		o.setUser(dbu);
		return odao.addOwner(o);	
	}
	
	@Override
	public Owner getOwnerById(int oid) {
		return odao.getOwnerById(oid);
	}

	@Override
	public void updateOwner(Owner o) {
		odao.updateOwner(o);
	}

	@Override
	public void removeOwner(int oid) {
		odao.removeOwner(oid);
	}

	@Override
	public List<Owner> getAllOwners() {
		return odao.getAllOwners();
	}	
}
