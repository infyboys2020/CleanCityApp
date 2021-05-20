package com.clean.springbootstarter.beans;

import java.io.InputStream;

public class Complaint {
	private int id;
	private String type;
	private String name;
	private String address;
	private String pin;
	private String phone_number;
	private InputStream photo;
	private String longitude;
	private String latitude;

	public Complaint() {
		
	}
	
	public Complaint(int id, String type, String name, String address, String pin, String phone_number,
			InputStream photo, String longitude, String latitude) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.address = address;
		this.pin = pin;
		this.phone_number = phone_number;
		this.photo = photo;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Complaint(int id, String type, String name, String address, String pin, String phone_number,
			String longitude, String latitude) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.address = address;
		this.pin = pin;
		this.phone_number = phone_number;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public  Complaint(String name, String address,String pin,String phone_number, InputStream photo) {
		
		this.name=name;
		this.address=address;
		this.pin=pin;
		this.phone_number=phone_number;
		this.photo=photo;
		
	}

public  Complaint(String name, String address,String pin,String phone_number) {
		
		this.name=name;
		this.address=address;
		this.pin=pin;
		this.phone_number=phone_number;
		
		
	}
	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public InputStream getPhoto() {
		return photo;
	}

	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
