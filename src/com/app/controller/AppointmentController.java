package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Appointment;
import com.app.service.IAppointmentService;

@RestController
@CrossOrigin
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private IAppointmentService s;
	
	@PostMapping(value = "/addAppointment", consumes = "application/json", produces = "application/json")
	public Integer addAppointment(@RequestBody Appointment a) {
		
		System.out.println(a);
		
		return s.addAppointment(a);
	}

	@PostMapping(value="")
	public Appointment getAppointmentById(int apid) {
		return getAppointmentById(apid);
	}

}
