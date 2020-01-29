package com.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Services;
import com.app.service.IServiceService;

@RestController
@CrossOrigin
@RequestMapping("/service")
public class ServiceController {

	@Autowired
	private IServiceService service;
	
	@PostMapping("/addService")
	ResponseEntity<?> addService(@RequestParam String name, @RequestParam String desc,@RequestParam String price,
								 @RequestParam(value = "image", required = false) MultipartFile image) 
	{		
		Services s = new Services(name, desc, Double.parseDouble(price));
		try 
		{
			s.setImage(image.getBytes());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
			
		return new ResponseEntity<Integer>(service.addService(s), HttpStatus.CREATED);
	}

	/*
	 * @PostMapping("/addService") ResponseEntity<?> addService(@RequestBody
	 * Services s) {
	 * 
	 * return new ResponseEntity<Integer>(service.addService(s),
	 * HttpStatus.CREATED); }
	 */
	
	@GetMapping("/getServiceById/{sid}")
	ResponseEntity<?> getServiceById(@PathVariable(name = "sid") String sid) {
		int i = Integer.parseInt(sid);
		System.out.println("sid :" + sid);
		return new ResponseEntity<Services>(service.getServiceById(i), HttpStatus.CREATED);
	}

	@PostMapping("/updateService")
	ResponseEntity<?> updateService(@RequestBody Services s) {
		service.updateService(s);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/removeService/{sid}")
	ResponseEntity<?> removeService(@PathVariable(name = "sid") String sid) {
		System.out.println("sid :" + sid);
		int i = Integer.parseInt(sid);
		service.removeService(i);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getServices")
	ResponseEntity<?> getServices() {
		return new ResponseEntity<List<Services>>(service.getServices(), HttpStatus.OK);
	}

	@GetMapping("/getServicesByServiceCenter")
	ResponseEntity<?> getServicesByServiceCenter(@RequestParam int scid) {
		return new ResponseEntity<Set<Services>>(service.getServicesByServiceCenterId(scid), HttpStatus.OK);
	}
	
	@GetMapping("/getServicesByAppointmentId")
	ResponseEntity<?> getServicesByAppointmentId(@RequestParam int apid) {
		return new ResponseEntity<Set<Services>>(service.getServicesByAppointmentId(apid), HttpStatus.OK);
	}

}