package com.app.controller;

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
		return new ResponseEntity<Address>(a, HttpStatus.OK);
	}
	
	@GetMapping("/deleteAddressByAddressId")
	ResponseEntity<?> deleteAddressByAddressId(@PathVariable String ids) {
		int aid = Integer.parseInt(ids);
		return new ResponseEntity<Address>(service.getAddressByAddressId(aid), HttpStatus.OK);
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
	

	@GetMapping("/getCustomerAddressesByCustomerId/{cid}")
	ResponseEntity<?> getCustomerAddressesByCustomerId(@PathVariable Integer cid) {
		return new ResponseEntity<Address>(service.getCustomerAddressesByCustomerId(cid), HttpStatus.OK);
	}

	@PostMapping("/removeCustomerAddress")
	ResponseEntity<?> removeCustomerAddress(@RequestParam int cid) {
		service.removeCustomerAddress(cid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
