package com.app.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Appointment;
import com.app.pojos.Customer;
import com.app.pojos.Services;
import com.app.pojos.Status;
import com.app.service.IAppointmentService;

@RestController
@CrossOrigin
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private IAppointmentService s;

	@PostMapping(value = "/addAppointment", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addAppointment(@RequestBody Appointment a) {
		// cust using
		// System.out.println(a);
		return new ResponseEntity<Integer>(s.addAppointment(a), HttpStatus.CREATED);
	}

	@GetMapping(value = "GetCustomerAppointments/{cid}")
	public ResponseEntity<?> getCustomerAppointments(@PathVariable Integer cid) {
		// cust using
		return new ResponseEntity<List<Appointment>>(s.getCustomerAppointments(cid), HttpStatus.OK);
	}

	@GetMapping(value = "DeleteCustomerAppointment/{apid}")
	public ResponseEntity<?> deleteCustomerAppointment(@PathVariable Integer apid) {
		// cust using
		return new ResponseEntity<Status>(s.cancelAppointment(apid),HttpStatus.OK);
	}
	//------------------------------------------------------------------------------------------------------
	@GetMapping(value = "getServiceCenterAppointments/{oid}")
	public ResponseEntity<?> getServiceCenterAppointments(@PathVariable Integer oid) {
		// owner using
		return new ResponseEntity<List<Appointment>>(s.getServiceCenterAppointments(oid), HttpStatus.OK);
	}

	@GetMapping(value = "getServicesByAppointmentById/{apid}")
	public ResponseEntity<?> getServicesByAppointmentById(@PathVariable Integer apid) {
		// owner using
		return new ResponseEntity<Set<Services>>(s.getServicesByAppointmentById(apid), HttpStatus.OK);
	}

	@GetMapping(value = "acceptAppointment/{apid}")
	public ResponseEntity<?> acceptAppointment(@PathVariable Integer apid) {
		// owner using
		return new ResponseEntity<Status>(s.acceptAppointment(apid),HttpStatus.OK);
	}
	//------------------------------------------------------------------------------------------------------
	@GetMapping(value = "getAppointmentById/{apid}")
	public ResponseEntity<?> getAppointmentById(@PathVariable Integer apid) {
		// cust using
		return new ResponseEntity<Appointment>(s.getAppointmentById(apid), HttpStatus.OK);
	}
	
	

}
