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
import com.app.service.IAddressService;

@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private IAddressService service;

	@GetMapping("/getAddressByAddressId/{ids}")
	ResponseEntity<?> getAddressByAddressId(@PathVariable String ids) {
		int aid = Integer.parseInt(ids);
		
		Address a=  service.getAddressByAddressId(aid);
		
		System.out.println(a);
		
		return new ResponseEntity<Address>(a, HttpStatus.OK);
	}
	
	@GetMapping("/deleteAddressByAddressId")
	ResponseEntity<?> deleteAddressByAddressId(@PathVariable String ids) {
		int aid = Integer.parseInt(ids);
		return new ResponseEntity<Address>(service.getAddressByAddressId(aid), HttpStatus.OK);
	}	
	
	// ----------------------------------------------------------------------------------------------
	// OwnerAddress
	// ----------------------------------------------------------------------------------------------
	@GetMapping("/getOwnerAddressByOwnerId")
	ResponseEntity<?> getOwnerAddressByOwnerId(@RequestParam int oid) {
		return new ResponseEntity<Address>(service.getOwnerAddressByOwnerId(oid), HttpStatus.OK);
	}

	@PostMapping("/addOrUpdateOwnerAddress")
	ResponseEntity<?> addOrUpdateOwnerAddress(@RequestParam int oid, @RequestBody Address oa) {
		service.addOrUpdateOwnerAddress(oid, oa);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/removeOwnerAddress")
	ResponseEntity<?> removeOwnerAddress(@RequestParam int oid) {
		service.removeOwnerAddress(oid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//----------------------------------------------------------------------------------------------
	//ServiceCenterAddress
	//----------------------------------------------------------------------------------------------		
	@GetMapping("/getServiceCenterAddressByServiceCenterId")
	ResponseEntity<?> getServiceCenterAddressByServiceCenterId(@RequestParam int scid) {
		return new ResponseEntity<Address>(service.getServiceCenterAddressByServiceCenterId(scid), HttpStatus.OK);
	}

	@PostMapping("/addOrUpdateServiceCenterAddress")
	ResponseEntity<?> addOrUpdateServiceCenterAddress(@RequestParam int scid, @RequestBody Address sca) {
		service.addOrUpdateServiceCenterAddress(scid, sca);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/removeServiceCenterAddress")
	ResponseEntity<?> removeServiceCenterAddress(@RequestParam int scid) {
		service.removeServiceCenterAddress(scid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//----------------------------------------------------------------------------------------------
	//CustomerAddress
	//----------------------------------------------------------------------------------------------	
	@PostMapping("/addCustomerAddress/{cid}")
	ResponseEntity<?> addCustomerAddress(@PathVariable Integer cid, @RequestBody Address ca) {
		
		service.addCustomerAddress(cid, ca);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/getCustomerAddressesByCustomerId/{cid}")
	ResponseEntity<?> getCustomerAddressesByCustomerId(@PathVariable Integer cid) {
		return new ResponseEntity<List<Address>>(service.getCustomerAddressesByCustomerId(cid), HttpStatus.OK);
	}

	@PostMapping("/removeCustomerAddress")
	ResponseEntity<?> removeCustomerAddress(@RequestParam int cid, int caid) {
		service.removeCustomerAddress(cid, caid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	/*
	 * @PostMapping("/addOrUpdateAddress/{role}/{ids}") ResponseEntity<?>
	 * addOrUpdateAddress(@PathVariable String role, @PathVariable String
	 * ids, @RequestBody Address a) { int id = Integer.parseInt(ids);
	 * 
	 * if (role.equals("CUSTOMER")) { adao.addOrUpdateCustomerAddress(id, a); } else
	 * if (role.equals("OWNER")) { adao.addOrUpdateOwnerAddress(id, a); } else if
	 * (role.equals("SERVICECENTER")) { adao.addOrUpdateServiceCenterAddress(id, a);
	 * } return new ResponseEntity<>(HttpStatus.CREATED); }
	 */

}
