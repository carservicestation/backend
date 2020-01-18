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
	
	@GetMapping("/getvehicles")
	ResponseEntity<?> getAllVehicles()
	{
		return new ResponseEntity<List<Vehicle>>(vdao.getVehicles(), HttpStatus.OK);
	}
	

}
