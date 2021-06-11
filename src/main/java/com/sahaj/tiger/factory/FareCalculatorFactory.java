package com.sahaj.tiger.factory;

public class FareCalculatorFactory {
	
	public static FareCalculator getInstance(String capType) {
		if(capType.equalsIgnoreCase("daily"))
			return new DailyFareCalculator();
		else if(capType.equalsIgnoreCase("weekly"))
			return new WeeklyFareCalculator();
		else
			return null;
	}
	
}
