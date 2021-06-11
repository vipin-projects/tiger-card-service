package com.sahaj.tiger.factory;

import java.util.Map;

/**
 * This class will calculate fare for daily journey inputs
 * @author Vipin
 *
 */
public class DailyFareCalculator implements FareCalculator {
	
	/**
	 * This method will calculate the fare return the Map along with Day and fare as output.
	 */
	@Override
	public Map<String, Integer> calculateTotalFare(Map<String, Integer> inputs, Integer dailyLimit, Integer weeklyLimit) {
		
		for (Map.Entry<String, Integer> e : inputs.entrySet()) {
			if(e.getValue() > dailyLimit)
				inputs.put(e.getKey(), dailyLimit);
		}
		
		return inputs;
		
	}

}
