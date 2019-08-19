package com.kart.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DriverResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2451589817026512260L;

	private Integer position;
	private Driver driver;
	private List<Round> rounds;
	private Round bestRound;
	private Double averageSpeed;
	private LocalTime timeAfterFirst;
	private LocalTime totalTime;
	private Integer laps;

	public Integer getLaps() {
		return laps;
	}

	public void setLaps(Integer laps) {
		this.laps = laps;
	}

	public DriverResult() {
		super();
		this.rounds = new ArrayList<>();
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

	public Round getBestRound() {
		return bestRound;
	}

	public void setBestRound(Round bestRound) {
		this.bestRound = bestRound;
	}

	public Double getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(Double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	public LocalTime getTimeAfterFirst() {
		return timeAfterFirst;
	}

	public void setTimeAfterFirst(LocalTime timeAfterFirst) {
		this.timeAfterFirst = timeAfterFirst;
	}

	public LocalTime getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(LocalTime totalTime) {
		this.totalTime = totalTime;
	}
}
