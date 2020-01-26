package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.app.dao.*;

import com.app.pojos.*;
import com.app.service.IOwnerService;

@RestController
@CrossOrigin
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private IOwnerService os;

	@PostMapping("/addOwner")
	ResponseEntity<?> addOwner(@RequestBody Owner o) {
		System.out.println(o.toString());
		return new ResponseEntity<Owner>(os.addOwner(o), HttpStatus.CREATED);
	}

	@GetMapping("/getOwnerById")
	ResponseEntity<?> getOwnerById(@RequestParam int oid) {
		return new ResponseEntity<Owner>(os.getOwnerById(oid), HttpStatus.OK);
	}

	@PostMapping("/updateOwner")
	ResponseEntity<?> updateOwner(@RequestBody Owner o) {
		os.updateOwner(o);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/removeOwner")
	ResponseEntity<?> removeOwner(@RequestParam int oid) {
		os.removeOwner(oid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getAllOwners")/*C*/
	ResponseEntity<?> getAllOwners() {
		return new ResponseEntity<List<Owner>>(os.getAllOwners(), HttpStatus.OK);
	}
}
