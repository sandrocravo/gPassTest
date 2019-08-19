package com.kart.help;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import com.kart.model.DriverResult;
import com.kart.model.Round;

public class PrintResult {

	 private static DecimalFormat df = new DecimalFormat("#.###");
	
	public static void printRace(List<DriverResult> race) {

		System.out.println(String.format("%20s", "Race Finish"));
		System.out.print(String.format("%10s", "Position"));
		System.out.print(String.format("%10s", "Number Pilot"));
		System.out.print(String.format("%20s", "Name Pilot"));
		System.out.print(String.format("%20s", "Laps Complete"));
		System.out.println(String.format("%20s", "Total Time"));
		for (int i = 0; i < race.size(); i++) {
			DriverResult dr = race.get(i);
			System.out.print(String.format("%10s", i + 1));
			System.out.print(String.format("%10s", dr.getDriver().getNumber()));
			System.out.print(String.format("%20s", dr.getDriver().getName()));
			System.out.print(String.format("%20s", dr.getRounds().size()));
			System.out.println(String.format("%20s", dr.getTotalTime()));
		}

	}

	public static void printBestLap(List<DriverResult> race) {
		System.out.println(String.format("%20s", "Best Lap By Pilot"));

		System.out.print(String.format("%10s", "Number Pilot"));
		System.out.print(String.format("%20s", "Name Pilot"));
		System.out.print(String.format("%10s", "Lap"));
		System.out.print(String.format("%20s", "Time"));
		System.out.println(String.format("%20s", "Speed average"));
		for (int i = 0; i < race.size(); i++) {
			DriverResult dr = race.get(i);
			System.out.print(String.format("%10s", dr.getDriver().getNumber()));
			System.out.print(String.format("%20s", dr.getDriver().getName()));
			System.out.print(String.format("%10s", dr.getBestRound().getNumber()));
			System.out.print(String.format("%20s", dr.getBestRound().getTime()));
			System.out.println(String.format("%20s",  dr.getBestRound().getAverageSpeed()));
		}

	}
	
	public static void printAverageSpeed(List<DriverResult> race) {
		System.out.println(String.format("%20s", "Average Speed"));

		System.out.print(String.format("%10s", "Number Pilot"));
		System.out.print(String.format("%20s", "Name Pilot"));
		System.out.println(String.format("%20s", "Speed average"));
		for (int i = 0; i < race.size(); i++) {
			DriverResult dr = race.get(i);
			System.out.print(String.format("%10s", dr.getDriver().getNumber()));
			System.out.print(String.format("%20s", dr.getDriver().getName()));;
			System.out.println(String.format("%20s",  df.format(dr.getAverageSpeed())));
		}

	}
	
	
	public static void printTimeAfterFirst(List<DriverResult> race) {
		System.out.println(String.format("%20s", "Time After First"));

		System.out.print(String.format("%10s", "Number Pilot"));
		System.out.print(String.format("%20s", "Name Pilot"));
		System.out.println(String.format("%20s", "Time After First"));
		for (int i = 0; i < race.size(); i++) {
			DriverResult dr = race.get(i);
			System.out.print(String.format("%10s", dr.getDriver().getNumber()));
			System.out.print(String.format("%20s", dr.getDriver().getName()));;
			System.out.println(String.format("%20s",  dr.getTimeAfterFirst()));
		}

	}
	
	
	
	public static void printBestLapAll(List<DriverResult> race) {
		System.out.println(String.format("%20s", "Best Lap"));

		System.out.print(String.format("%10s", "Number Pilot"));
		System.out.print(String.format("%20s", "Name Pilot"));
		System.out.print(String.format("%10s", "Lap"));
		System.out.print(String.format("%20s", "Time"));
		System.out.println(String.format("%20s", "Speed average"));
					
			DriverResult dr = race.get(0);
			
			for (DriverResult driverResult2 : race) {
				if(driverResult2.getBestRound().getTime().compareTo(dr.getBestRound().getTime()) < 0) {
					dr = driverResult2;
				}
					
			}
			
			System.out.print(String.format("%10s", dr.getDriver().getNumber()));
			System.out.print(String.format("%20s", dr.getDriver().getName()));
			System.out.print(String.format("%10s", dr.getBestRound().getNumber()));
			System.out.print(String.format("%20s", dr.getBestRound().getTime()));
		

	}

}
