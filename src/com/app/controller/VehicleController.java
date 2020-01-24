package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.app.dao.*;
import com.app.pojos.*;
import com.app.service.IVehicleService;

@RestController
@CrossOrigin
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private IVehicleService service;
	
	@PostMapping("/addVehicle")
	ResponseEntity<?> addVehicle(@RequestBody Vehicle v)
	{
		return new ResponseEntity<Integer>(service.addVehicle(v), HttpStatus.OK);
	}
	
	@GetMapping("/getVehicleById")
	ResponseEntity<?> getVehicleById(@RequestParam int vid)
	{
		return new ResponseEntity<Vehicle>(service.getVehicleById(vid), HttpStatus.OK);
	}
	
	@PostMapping("/updateVehicle")
	ResponseEntity<?> updateVehicle(@RequestBody Vehicle v)
	{
		service.updateVehicle(v);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/removeVehicle")
	ResponseEntity<?> removeVehicle(@RequestParam int vid)
	{
		service.removeVehicle(vid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getVehicles")
	ResponseEntity<?> getVehicles()
	{
		return new ResponseEntity<List<Vehicle>>(service.getVehicles(), HttpStatus.OK);
	}
	

}