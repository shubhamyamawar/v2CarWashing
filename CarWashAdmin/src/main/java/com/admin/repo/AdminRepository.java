package com.admin.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.admin.models.Customer;
import com.admin.models.WashPacks;

@Repository
public interface AdminRepository extends MongoRepository<WashPacks, Integer>{

	Object save(Customer customer);
	
	List<WashPacks> findByPackname(String name);
	
}
