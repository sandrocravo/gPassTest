package com.kart.process.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.kart.model.Driver;
import com.kart.model.DriverResult;
import com.kart.model.Round;
import com.kart.process.DriverFinalResult;

public class DriverFinalResultImpl implements DriverFinalResult {

	@Override
	public List<DriverResult> logToDriverResult(Stream<String> log) {

		List<DriverResult> driverResults = new ArrayList<>();

		List<String> logLine = log.skip(1).collect(Collectors.toList());

		logLine.forEach(line -> addDriver(line.split("\\s+"), driverResults));
		logLine.forEach(line -> addRound(line.split("\\s+"), driverResults));
		addBestAndTotal(driverResults);
		addTotalLaps(driverResults);
		addAvgSpeed(driverResults);

		Comparator<DriverResult> compareByResult = Comparator.comparing(DriverResult::getLaps).reversed()
				.thenComparing(DriverResult::getTotalTime);
		Collections.sort(driverResults, compareByResult);

		addTimeAfterFirst(driverResults);

		return driverResults;
	}

	private static void addDriver(String[] logLine, List<DriverResult> driverResults) {
		DriverResult driverResult = new DriverResult();

		String driverNumber = logLine[1];

		if (driverResults.stream().noneMatch(dr -> dr.getDriver().getNumber().equals(logLine[1]))) {
			driverResult.setDriver(new Driver(driverNumber, logLine[3]));
			driverResults.add(driverResult);
		}
	}

	private static void addRound(String[] logLine, List<DriverResult> driverResults) {
		String driverNumber = logLine[1];
		driverResults.stream().filter(dr -> dr.getDriver().getNumber().equals(driverNumber))
				.forEach(dr -> dr.getRounds().add(new Round(Integer.valueOf(logLine[4]),
						LocalTime.parse("00:0" + logLine[5]), Double.valueOf(logLine[6].replace(",", ".")))));
	}

	private static void addBestAndTotal(List<DriverResult> driverResults) {

		for (DriverResult driverResult : driverResults) {
			driverResult.setBestRound(driverResult.getRounds().stream().min(Comparator.comparing(Round::getTime))
					.orElseThrow(NoSuchElementException::new));
			LocalTime total = LocalTime.of(0, 0, 0, 0);
			for (Round round : driverResult.getRounds()) {
				total = total.plusMinutes(round.getTime().getMinute()).plusSeconds(round.getTime().getSecond())
						.plusNanos(round.getTime().getNano());
			}
			driverResult.setTotalTime(total);
		}
	}

	private static void addTotalLaps(List<DriverResult> driverResults) {
		driverResults.stream().forEach(dr -> dr.setLaps(dr.getRounds().size()));
	}

	private static void addAvgSpeed(List<DriverResult> driverResults) {
		for (DriverResult driverResult : driverResults) {
			driverResult.setAverageSpeed(
					driverResult.getRounds().stream().mapToDouble(d -> d.getAverageSpeed()).average().getAsDouble());
		}
	}

	private static void addTimeAfterFirst(List<DriverResult> driverResults) {
		DriverResult driverResult = driverResults.get(0);
		driverResults.stream()
				.forEach(dr -> dr.setTimeAfterFirst(dr.getTotalTime().minusNanos(driverResult.getTotalTime().getNano())
						.minusSeconds(driverResult.getTotalTime().getSecond())
						.minusMinutes(driverResult.getTotalTime().getMinute())));
	}

}
