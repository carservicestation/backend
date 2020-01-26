package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.app.dao.*;
import com.app.pojos.*;
import com.app.service.IServiceCenterService;

@RestController
@CrossOrigin
@RequestMapping("/servicecenter")
public class ServiceCenterController {
	
	@Autowired
	private IServiceCenterService service;
	
	@GetMapping("/addServiceCenter")
	ResponseEntity<?> addServiceCenter(@RequestBody ServiceCenter sc)
	{
		return new ResponseEntity<Integer>(service.addServiceCenter(sc), HttpStatus.OK);
	}
	
	@GetMapping("/getServiceCenterById")
	ResponseEntity<?> getServiceCenterById(@RequestBody int scid)
	{
		return new ResponseEntity<ServiceCenter>(service.getServiceCenterById(scid), HttpStatus.OK);
	}
	
	@GetMapping("/updateServiceCenter")
	ResponseEntity<?> updateServiceCenter(@RequestBody ServiceCenter sc)
	{
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/removeServiceCenter")
	ResponseEntity<?> removeServiceCenter(@RequestBody int scid)
	{
		service.removeServiceCenter(scid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getServiceCenters")
	ResponseEntity<?> getServiceCenters()
	{
		return new ResponseEntity<List<ServiceCenter>>(service.getServiceCenters(), HttpStatus.OK);
	}
	
	@GetMapping("/getServiceCentersByOwnerId")
	ResponseEntity<?> getServiceCentersByOwnerId(int oid)
	{
		return new ResponseEntity<ServiceCenter>(service.getServiceCentersByOwnerId(oid), HttpStatus.OK);
	}
}