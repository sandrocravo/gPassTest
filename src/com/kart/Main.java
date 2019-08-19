package com.kart;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import com.kart.help.PrintResult;
import com.kart.model.DriverResult;
import com.kart.process.DriverFinalResult;
import com.kart.process.impl.DriverFinalResultImpl;

public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		Stream<String> stream = null;
		try {
			stream = Files.lines(Paths.get(args[0]), StandardCharsets.ISO_8859_1);
			
			DriverFinalResult driverFinalResult = new DriverFinalResultImpl();
			List<DriverResult> race = driverFinalResult.logToDriverResult(stream);

			PrintResult.printRace(race);
			
			PrintResult.printBestLap(race);
			
			PrintResult.printAverageSpeed(race);
			
			PrintResult.printTimeAfterFirst(race);
			
			PrintResult.printBestLapAll(race);

		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Problem with file!");
		} finally {
			stream.close();
		}
	}

}
