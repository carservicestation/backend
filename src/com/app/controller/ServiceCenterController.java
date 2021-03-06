package com.app.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.app.dao.*;
import com.app.pojos.*;
import com.app.service.IServiceCenterService;

@CrossOrigin
@RestController
@RequestMapping("/servicecenter")
public class ServiceCenterController {
	
	@Autowired
	private IServiceCenterService service;
	

	@GetMapping(value="/getServiceCenters", produces = "application/json")
	ResponseEntity<?> getServiceCenters()
	{
		//admin using
		return new ResponseEntity<List<ServiceCenter>>(service.getServiceCenters(), HttpStatus.OK);
	}
	
	@GetMapping("/removeServiceCenter/{scid}")
	ResponseEntity<?> removeServiceCenter(@PathVariable Integer scid)
	{
		//admin using
		service.removeServiceCenter(scid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping(value="/addServiceCenter",consumes = "application/json",produces = "application/json")
	ResponseEntity<?> addServiceCenter(@RequestBody ServiceCenter sc)
	{
		System.out.println(sc.toString());

		
		Owner o = sc.getOwner();
		o.setServiceCenter(sc);
		
		Set<Services> l = sc.getServices();
		
		sc.getServices().addAll(l);
		
		System.out.println(sc.toString());
		return new ResponseEntity<Integer>(service.addServiceCenter(sc), HttpStatus.OK);
	}
	
	@GetMapping("/GetServicesByServiceCenter/{scid}")
	ResponseEntity<?> getServiceCenterById(@PathVariable Integer scid)
	{
		return new ResponseEntity<Set<Services>>(service.getServiceCenterById(scid), HttpStatus.OK);
	}
	
	@GetMapping("/updateServiceCenter")
	ResponseEntity<?> updateServiceCenter(@RequestBody ServiceCenter sc)
	{
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@GetMapping("/GetServiceCenterByOwnerId/{oid}")
	ResponseEntity<?> getServiceCentersByOwnerId(@PathVariable Integer oid)
	{
		return new ResponseEntity<ServiceCenter>(service.getServiceCentersByOwnerId(oid), HttpStatus.OK);
	}

	@GetMapping("/GetServiceCentersNearCustomer/{cid}")
	ResponseEntity<?> GetServiceCentersNearCustomer(@PathVariable Integer cid)
	{
		return new ResponseEntity<List<ServiceCenter>>(service.GetServiceCentersNearCustomer(cid), HttpStatus.OK);
	}
	
}














