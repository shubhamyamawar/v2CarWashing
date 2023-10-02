package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.admin.exception.WashpackNotFoundException;
import com.admin.models.ListCustomer;
import com.admin.models.ListWashers;
import com.admin.models.WashPacks;
import com.admin.models.WasherLeaderboard;
import com.admin.service.AdminServiceImpl;


@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminServiceImpl;


	@Autowired
	private RestTemplate restTemplate;
	

//	Method to add washpack
	@PostMapping("/add-pack")
	public ResponseEntity<Object> bookWash(@RequestBody WashPacks packs) {
		WashPacks washPacks = adminServiceImpl.addNewWashPack(packs);
		return new ResponseEntity<>(washPacks, HttpStatus.CREATED);
	}
	
	

//	Method to get washpack by name
	@GetMapping("/get-pack/{name}")
	public List<WashPacks> pack(@PathVariable("name") String name) {
		return adminServiceImpl.getByName(name);
	}
	

	

//	Method to get washpack by id
	@GetMapping("{packId}")
	public ResponseEntity<Object> getCarById(@PathVariable int packId) {
		return new ResponseEntity<>(adminServiceImpl.findWashpacksById(packId), HttpStatus.OK);
	}
	
	

//	Method to get all washpacks
	@GetMapping("/all-packs")
	public ResponseEntity<List<WashPacks>> allPacks() {
		List<WashPacks> washpacks = adminServiceImpl.getAllWashpacks();
		return new ResponseEntity<List<WashPacks>>(washpacks, HttpStatus.OK);
	}

	
	
//	Method to edit washpack by id
	@PutMapping("/edit-pack")
	public ResponseEntity<WashPacks> updateWashpacks(@RequestBody WashPacks washPacks) {
		return new ResponseEntity<WashPacks>(adminServiceImpl.editWashPack(washPacks), HttpStatus.OK);
	}

	
	
	
//	Method to load all the customers
//	*****************************************************************  Another Class
	@GetMapping("/customers")
	public ResponseEntity<Object> listOfCustomers() {
		
		ResponseEntity<ListCustomer> list = restTemplate.getForEntity("http://customer-microservice/customer/get-all-customer",
				ListCustomer.class);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	

//    Method to load all the washers
//	*****************************************************************  //
	@GetMapping("/washers")
	public ResponseEntity<ListWashers> listOfWashers() {
//        return new ResponseEntity<>(adminServiceImpl.listOfWashers(), HttpStatus.OK);
		ListWashers list = restTemplate.getForObject("http://washer-microservice/washer/get-all-washer",
				ListWashers.class);

		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	
	
	
//  Method to display the leaderboard
//	***************************************************   //
	@GetMapping("/leaderboard")
	public ResponseEntity<List<WasherLeaderboard>> washerLeaderboard() {
		List<WasherLeaderboard> washerLeaderboard = adminServiceImpl.getWasherLeaderboard();
		return new ResponseEntity<List<WasherLeaderboard>>(washerLeaderboard, HttpStatus.OK);
	}
	
	
	

//	Method to add washpack
	@PostMapping("/add-leaderboard")
	public ResponseEntity<WasherLeaderboard> addToLeaderBoard(@RequestBody WasherLeaderboard washerLeaderboard) {

		WasherLeaderboard washerLeaderboard2 = adminServiceImpl.addToLeaderboard(washerLeaderboard);

		return new ResponseEntity<WasherLeaderboard>(washerLeaderboard2, HttpStatus.CREATED);

	}
	
	

//	Deleting washpack by id
	@DeleteMapping("/delete/{packId}")
	public void deleteById(@PathVariable("packId") int packId)throws WashpackNotFoundException {
		this.adminServiceImpl.deleteWashpackById(packId);
	}

}
