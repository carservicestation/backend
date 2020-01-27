package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.app.pojos.*;
import com.app.service.IOwnerService;

@RestController
@CrossOrigin
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private IOwnerService os;

	@GetMapping(value="/getAllOwners", produces = "application/json")
	ResponseEntity<?> getAllOwners() 
	{
		//admin using
		return new ResponseEntity<List<Owner>>(os.getAllOwners(), HttpStatus.OK);
	}
	
	@GetMapping("/removeOwner/{oid}")
	ResponseEntity<?> removeOwner(@PathVariable int oid) 
	{
		//admin using cascade all works
		os.removeOwner(oid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping("/addOwner")
	ResponseEntity<?> addOwner(@RequestBody Owner o) {
		//owner//signup
		return new ResponseEntity<Owner>(os.addOwner(o), HttpStatus.CREATED);
	}

	@GetMapping("/getOwnerById/{oid}")
	ResponseEntity<?> getOwnerById(@PathVariable Integer oid) {
		//owner using
		return new ResponseEntity<Owner>(os.getOwnerById(oid), HttpStatus.OK);
	}

	@PostMapping("/updateOwner")
	ResponseEntity<?> updateOwner(@RequestBody Owner o) {
		//owner using
		os.updateOwner(o);
		return new ResponseEntity<>(HttpStatus.OK);
	}	
}
