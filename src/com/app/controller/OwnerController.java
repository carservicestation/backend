package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.app.dao.*;

import com.app.pojos.*;

@RestController
@CrossOrigin
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private IOwnerDao odao;

	@PostConstruct
	public void init() {
		System.out.println("in init " + odao);
	}

	@PostMapping("/addowner")
	ResponseEntity<?> addOwner(@RequestBody Owner o) {
		return new ResponseEntity<Integer>(odao.addOwner(o), HttpStatus.CREATED);
	}

	@GetMapping("/getownerbyid")
	ResponseEntity<?> getOwner(@RequestParam int oid) {
		return new ResponseEntity<Owner>(odao.getOwnerById(oid), HttpStatus.OK);
	}

	@PostMapping("/updateowner")
	ResponseEntity<?> updateOwner(@RequestBody Owner o) {
		odao.updateOwner(o);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/removeowner")
	ResponseEntity<?> removeOwner(@RequestParam int oid) {
		odao.removeOwner(oid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/addorupdateowneraddress")
	ResponseEntity<?> addOrUpdateOwnerAddress(@RequestParam int oid, @RequestBody OwnerAddress oa)
	{
		odao.addOrUpdateOwnerAddress(oid,oa);
		return new ResponseEntity<>( HttpStatus.CREATED);
	}
	
	@GetMapping("/getowneraddressbyoid")
	ResponseEntity<?> getOwnerAddress( @RequestParam int oid)
	{
		return new ResponseEntity<OwnerAddress>(odao.getOwnerAddress(oid), HttpStatus.OK);
	}
	
	@PostMapping("/removeowneraddress")
	ResponseEntity<?> removeOwnerAddress( @RequestParam int oid)
	{
		odao.removeOwnerAddress(oid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getowners")
	ResponseEntity<?> getAllOwners() {
		return new ResponseEntity<List<Owner>>(odao.getAllOwners(), HttpStatus.OK);
	}

}
