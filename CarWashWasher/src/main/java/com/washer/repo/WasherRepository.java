package com.washer.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.washer.models.Washer;

@Repository
public interface WasherRepository extends MongoRepository<Washer, Integer>{
	
	public List<Washer> findAll();
	
	public List<Washer> findByName(String name);
	
}
