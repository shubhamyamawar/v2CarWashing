package com.customerdetails.models;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	private ObjectId _id; 
	private int orderId;
	private String washName;
	private String carModel;
	private double amount;
	private String customerName;
//	private String washerName;
//	private AddOn addOn;
	private String date;
	private String paymentStatus;
	private String emailAddress;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getWashName() {
		return washName;
	}

	public void setWashName(String washName) {
		this.washName = washName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

//	public String getWasherName() {
//		return washerName;
//	}
//
//	public void setWasherName(String washerName) {
//		this.washerName = washerName;
//	}

//	public AddOn getAddOn() {
//		return addOn;
//	}
//
//	public void setAddOn(AddOn addOn) {
//		this.addOn = addOn;
//	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
