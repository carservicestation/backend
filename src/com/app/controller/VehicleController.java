package com.app.controller;

import java.util.List;

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
		//admin using
		return new ResponseEntity<Integer>(service.addVehicle(v), HttpStatus.OK);
	}

	@GetMapping("/getAllVehicles")
	ResponseEntity<?> getAllVehicles()
	{
		//admin using
		return new ResponseEntity<List<Vehicle>>(service.getVehicles(), HttpStatus.OK);
	}

	@GetMapping("/removeVehicle/{vid}")
	ResponseEntity<?> removeVehicle(@PathVariable Integer vid)
	{
		//admin using
		service.removeVehicle(vid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getVehicleById/{vid}")
	ResponseEntity<?> getVehicleById(@PathVariable Integer vid)
	{
		return new ResponseEntity<Vehicle>(service.getVehicleById(vid), HttpStatus.OK);
	}
	
	@PostMapping("/updateVehicle")
	ResponseEntity<?> updateVehicle(@RequestBody Vehicle v)
	{
		service.updateVehicle(v);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getDistinctVehicleMakes")
	ResponseEntity<?> getDistinctVehicleMakes()
	{
		//customer using
		return new ResponseEntity<List<String>>(service.getDistinctVehicleMakes(), HttpStatus.OK);
	}
	
	@PostMapping("/getModelsByVehicleMakes")
	ResponseEntity<?> getModelsByVehicleMakes(@RequestBody String make)
	{
		//customer using
		return new ResponseEntity<List<String>>(service.getModelsByVehicleMakes(make), HttpStatus.OK);
	}
	
	@PostMapping("/getFuels")
	ResponseEntity<?> getModelsByVehicleMakes(@RequestBody Vehicle v)
	{
		//customer using
		return new ResponseEntity<List<Fuel>>(service.getFuels(v), HttpStatus.OK);
	}
	
	
	
}







