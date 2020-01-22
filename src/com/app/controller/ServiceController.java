package com.app.controller;

import java.util.List;
import java.util.Set;

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

	@PostMapping("/addService")
	ResponseEntity<?> addService(@RequestBody Service s) {
		return new ResponseEntity<Integer>(sdao.addService(s), HttpStatus.CREATED);
	}

	@GetMapping("/getServiceById/{sid}")
	ResponseEntity<?> getServiceById(@PathVariable(name = "sid") String sid) {
		int i = Integer.parseInt(sid);
		System.out.println("sid :" + sid);
		return new ResponseEntity<Service>(sdao.getServiceById(i), HttpStatus.CREATED);
	}

	@PostMapping("/updateService")
	ResponseEntity<?> updateService(@RequestBody Service s) {
		sdao.updateService(s);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/removeService/{sid}")
	ResponseEntity<?> removeService(@PathVariable(name = "sid") String sid) {
		System.out.println("sid :" + sid);
		int i = Integer.parseInt(sid);
		sdao.removeService(i);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getServices")
	ResponseEntity<?> getServices() {
		return new ResponseEntity<List<Service>>(sdao.getServices(), HttpStatus.OK);
	}

	@GetMapping("/getServicesByServiceCenter")
	ResponseEntity<?> getServicesByServiceCenter(@RequestParam int scid) {
		return new ResponseEntity<Set<Service>>(sdao.getServicesByServiceCenter(scid), HttpStatus.OK);
	}

}
