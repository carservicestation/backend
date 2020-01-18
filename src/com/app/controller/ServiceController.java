package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dao.IServiceDao;
import com.app.pojos.Service;

@RestController
@CrossOrigin
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	private IServiceDao sdao;
	
	@PostMapping("/addservice")
	ResponseEntity<?> addService( @RequestBody Service s)
	{
		return new ResponseEntity<Integer>(sdao.addService(s), HttpStatus.CREATED);
	}
	
	@GetMapping("/getservices")
	ResponseEntity<?> getAllServices()
	{
		return new ResponseEntity<List<Service>>(sdao.getServices(), HttpStatus.OK);
	}

}
