package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.*;
import com.app.pojos.*;

@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private IAddressDao adao;

	@PostConstruct
	public void init() {
		System.out.println("in init " + adao);
	}

	@PostMapping("/addOrUpdateAddress/{role}/{ids}")
	ResponseEntity<?> addOrUpdateAddress(@PathVariable String role, @PathVariable String ids, @RequestBody Address a) {
		int id = Integer.parseInt(ids);

		if (role.equals("CUSTOMER")) {
			adao.addOrUpdateCustomerAddress(id, a);
		} else if (role.equals("OWNER")) {
			adao.addOrUpdateOwnerAddress(id, a);
		} else if (role.equals("SERVICECENTER")) {
			adao.addOrUpdateServiceCenterAddress(id, a);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/getAddressByAddressId/{ids}")
	ResponseEntity<?> getAddressByAddressId(@PathVariable String ids) {
		int aid = Integer.parseInt(ids);
		
		Address a=  adao.getAddressByAddressId(aid);
		
		System.out.println(a);
		
		return new ResponseEntity<Address>(a, HttpStatus.OK);
	}
	
	@GetMapping("/deleteAddressByAddressId")
	ResponseEntity<?> deleteAddressByAddressId(@PathVariable String ids) {
		int aid = Integer.parseInt(ids);
		return new ResponseEntity<Address>(adao.getAddressByAddressId(aid), HttpStatus.OK);
	}	
	
	// ----------------------------------------------------------------------------------------------
	// OwnerAddress
	// ----------------------------------------------------------------------------------------------
	@GetMapping("/getOwnerAddressByOwnerId")
	ResponseEntity<?> getOwnerAddressByOwnerId(@RequestParam int oid) {
		return new ResponseEntity<Address>(adao.getOwnerAddressByOwnerId(oid), HttpStatus.OK);
	}

	@PostMapping("/addOrUpdateOwnerAddress")
	ResponseEntity<?> addOrUpdateOwnerAddress(@RequestParam int oid, @RequestBody Address oa) {
		adao.addOrUpdateOwnerAddress(oid, oa);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/removeOwnerAddress")
	ResponseEntity<?> removeOwnerAddress(@RequestParam int oid) {
		adao.removeOwnerAddress(oid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//----------------------------------------------------------------------------------------------
	//ServiceCenterAddress
	//----------------------------------------------------------------------------------------------		
	@GetMapping("/getServiceCenterAddressByServiceCenterId")
	ResponseEntity<?> getServiceCenterAddressByServiceCenterId(@RequestParam int scid) {
		return new ResponseEntity<Address>(adao.getServiceCenterAddressByServiceCenterId(scid), HttpStatus.OK);
	}

	@PostMapping("/addOrUpdateServiceCenterAddress")
	ResponseEntity<?> addOrUpdateServiceCenterAddress(@RequestParam int scid, @RequestBody Address sca) {
		adao.addOrUpdateServiceCenterAddress(scid, sca);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/removeServiceCenterAddress")
	ResponseEntity<?> removeServiceCenterAddress(@RequestParam int scid) {
		adao.removeServiceCenterAddress(scid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//----------------------------------------------------------------------------------------------
	//CustomerAddress
	//----------------------------------------------------------------------------------------------	
	@PostMapping("/addOrUpdateCustomerAddress")
	ResponseEntity<?> addOrUpdateCustomerAddress(@RequestParam int cid, @RequestBody Address ca) {
		adao.addOrUpdateCustomerAddress(cid, ca);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/getCustomerAddressesByCustomerId")
	ResponseEntity<?> getCustomerAddressesByCustomerId(@RequestParam int cid) {
		return new ResponseEntity<List<Address>>(adao.getCustomerAddressesByCustomerId(cid), HttpStatus.OK);
	}

	@PostMapping("/removeCustomerAddress")
	ResponseEntity<?> removeCustomerAddress(@RequestParam int cid, int caid) {
		adao.removeCustomerAddress(cid, caid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
