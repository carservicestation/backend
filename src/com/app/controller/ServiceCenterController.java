package com.app.controller;

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
	
	

}
