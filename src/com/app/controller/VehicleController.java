package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.app.dao.*;
import com.app.pojos.*;

@RestController
@CrossOrigin
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private IVehicleDao vdao;
	
	@PostMapping("/addVehicle")
	ResponseEntity<?> addVehicle(@RequestBody Vehicle v)
	{
		return new ResponseEntity<Integer>(vdao.addVehicle(v), HttpStatus.OK);
	}
	
	@GetMapping("/getVehicleById")
	ResponseEntity<?> getVehicleById(@RequestParam int vid)
	{
		return new ResponseEntity<Vehicle>(vdao.getVehicleById(vid), HttpStatus.OK);
	}
	
	@PostMapping("/updateVehicle")
	ResponseEntity<?> updateVehicle(@RequestBody Vehicle v)
	{
		vdao.updateVehicle(v);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/removeVehicle")
	ResponseEntity<?> removeVehicle(@RequestParam int vid)
	{
		vdao.removeVehicle(vid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getVehicles")
	ResponseEntity<?> getVehicles()
	{
		return new ResponseEntity<List<Vehicle>>(vdao.getVehicles(), HttpStatus.OK);
	}
	

}
