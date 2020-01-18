package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.app.dao.*;
import com.app.pojos.*;

@RestController
@CrossOrigin
@RequestMapping("/servicecenter")
public class ServiceCenterController {
	
	@Autowired
	private IServiceCenterDao dao;
	
	@PostMapping("/addservice")
	ResponseEntity<?> addService( @RequestBody Service s)
	{
		return new ResponseEntity<Integer>(dao.addService(s), HttpStatus.CREATED);
	}
	
	@GetMapping("/getservices")
	ResponseEntity<?> getAllServices()
	{
		return new ResponseEntity<List<Service>>(dao.getServices(), HttpStatus.CREATED);
	}
	@GetMapping("/getcenters")
	ResponseEntity<?> getAllCenters()
	{
		return new ResponseEntity<List<ServiceCenter>>(dao.getServiceCenters(), HttpStatus.CREATED);
	}
	@GetMapping("/getvehicles")
	ResponseEntity<?> getAllVehicles()
	{
		return new ResponseEntity<List<Vehicle>>(dao.getVehicles(), HttpStatus.CREATED);
	}
	

}
