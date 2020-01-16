package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IServiceDao;
import com.app.pojos.Customer;
import com.app.pojos.Service;

@RestController
@CrossOrigin
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	private IServiceDao dao;
	
	@PostMapping("/addservice")
	ResponseEntity<?> addService( @RequestBody Service s)
	{
		return new ResponseEntity<Integer>(dao.addService(s), HttpStatus.CREATED);
	}

}
