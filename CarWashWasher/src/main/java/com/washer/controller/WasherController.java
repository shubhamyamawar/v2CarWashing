package com.washer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.washer.models.Washer;
import com.washer.service.WasherServiceImpl;

@RestController
@RequestMapping("/washer")
@CrossOrigin("*")
public class WasherController {

	Logger logger = LoggerFactory.getLogger(WasherController.class);

	@Autowired
	private WasherServiceImpl washerServiceImpl;

	// Method to add washer
	@PostMapping("/add-washer")
	public ResponseEntity<Washer> addWasher(@RequestBody Washer washer) {
		logger.trace("Add Washer Running");
		Washer washer2 = washerServiceImpl.addNewWasher(washer);
		return new ResponseEntity<Washer>(washer2, HttpStatus.CREATED);
	}

	// Method to get the washer by name
	@GetMapping("/get-washer/{name}")
	public ResponseEntity<List<Washer> >getWasherByName(@PathVariable String name) {
		logger.trace("Get Washer by Name Running");
		List<Washer> washer = washerServiceImpl.getUserByName(name);
		return new ResponseEntity<List<Washer>>(washer, HttpStatus.OK);
	}

	// Method to get all washers
	@GetMapping("/get-all-washer")
	public ResponseEntity<List<Washer>> getAllWasher() {
		logger.trace("Get All Washer Running");
		List<Washer> washer = washerServiceImpl.getAllWasher();
		return new ResponseEntity<List<Washer>>(washer, HttpStatus.OK);
	}

	// Method to update the profile of washers
	@PutMapping("/update-profile")
	public ResponseEntity<Washer> updateProfile(@RequestBody Washer washer) {

		logger.trace(" Washer Running");
		return new ResponseEntity<Washer>(washerServiceImpl.updateProfile(washer), HttpStatus.OK);
	}

}
