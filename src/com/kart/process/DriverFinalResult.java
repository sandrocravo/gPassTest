package com.kart.process;

import java.util.List;
import java.util.stream.Stream;

import com.kart.model.DriverResult;

public interface DriverFinalResult {
	
	public List<DriverResult> logToDriverResult(Stream<String> log);

}
