package com.kart.model;

import java.io.Serializable;

public class Driver implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7582597855183150032L;

	private String number;
	private String name;
	

	public Driver(String number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.number + " - " + this.name;
		
	}

}
