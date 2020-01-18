package com.app.controller;

import java.util.List;

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
	private IServiceCenterDao scdao;
	
	@GetMapping("/getcenters")
	ResponseEntity<?> getAllCenters()
	{
		return new ResponseEntity<List<ServiceCenter>>(scdao.getServiceCenters(), HttpStatus.OK);
	}
}
