package com.washer.service;

import java.util.List;

import com.washer.models.Order;
import com.washer.models.Washer;

public interface WasherService {

	public String washRequestFromCustomer();

	public List<Washer> getUserByName(String name);

	public Washer updateProfile(Washer washer);

	public Washer addNewWasher(Washer washer);
	
	public List<Washer>getAllWasher() ;

}
