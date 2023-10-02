package com.admin.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "washpacks")
public class WashPacks {

	@Id
	private int id;
	private String packname;
	private double amount;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackname() {
		return packname;
	}

	public void setPackname(String packname) {
		this.packname = packname;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	public WashPacks(int id, String packname, double amount, String description) {
		this.id = id;
		this.packname = packname;
		this.amount = amount;
		this.description = description;
	}

	public WashPacks() {
		
	}

	

}
