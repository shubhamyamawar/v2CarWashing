package com.washer.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.exception.FieldIsNessasaryException;
import com.washer.exception.WasherNotFoundException;
//import com.washer.filter.JwtFilter;
import com.washer.models.Order;
import com.washer.models.Washer;
import com.washer.repo.WasherRepository;

@Service
public class WasherServiceImpl implements WasherService {
	


	@Autowired
	private WasherRepository washerRepository;

	String msg;

    String washerName;


    @SuppressWarnings("unused")
	@Override
	public Washer addNewWasher(Washer washer) {
		Random random = new Random();
		washer.setId(random.nextInt(9999));
		if (washer == null) {
			throw new FieldIsNessasaryException("Fill in complete details");
		} else {
			washer.setRole("Washer");
			return washerRepository.save(washer);		
		}
		
	}
	
	@Override
	public String washRequestFromCustomer() {
		return msg;
	}

	@Override
	public List<Washer>getUserByName(String name) {
		List<Washer> wash = washerRepository.findByName(name);
		
		if(wash==null) {
			throw new WasherNotFoundException("Not found");
		}
		return wash;
	}

	@Override
	public Washer updateProfile(Washer washer) {
		washerRepository.findById(washer.getId()).orElseThrow(()->new WasherNotFoundException("Not found"));
		return washerRepository.save(washer);
	}

	

	@Override
	public List<Washer> getAllWasher(){
		
		return washerRepository.findAll();
	}

}
