package com.kart.model;

import java.io.Serializable;
import java.time.LocalTime;

public class Round implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3790849211477089902L;

	private Integer number;
	private LocalTime time;
	private Double averageSpeed;

	public Round(Integer number, LocalTime time, Double averageSpeed) {
		super();
		this.number = number;
		this.time = time;
		this.averageSpeed = averageSpeed;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Double getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(Double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	public String toString() {
		return this.number + " " + this.time + " " + this.averageSpeed;
	}

}
