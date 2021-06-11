package com.sahaj.tiger.factory;

import java.util.Map;

/**
 * This class will calculate fare for weekly inputs
 * @author Vipin
 *
 */
public class WeeklyFareCalculator implements FareCalculator {
	/**
	 * This method will calculate the fare return the Map along with Day and fare as output.
	 */
	@Override
	public Map<String, Integer> calculateTotalFare(Map<String, Integer> inputs, Integer dailyLimit, Integer weeklyLimit) {
		
		Integer sum = 0;
		for (Map.Entry<String, Integer> e : inputs.entrySet()) {
			if(e.getValue() > dailyLimit) {
				if(sum > weeklyLimit) {
					inputs.put(e.getKey(), 0);
				} else {
					if((sum+dailyLimit) > weeklyLimit) {
						inputs.put(e.getKey(), (weeklyLimit - sum));
						sum = sum + (weeklyLimit - sum);
					} else {
						sum+=dailyLimit;
						inputs.put(e.getKey(), dailyLimit);
					}
				}
				
			} else {
				if(sum > weeklyLimit) {
					inputs.put(e.getKey(), 0);
				} else {
					if((sum+e.getValue()) > weeklyLimit) {
						sum = sum + (weeklyLimit - sum);
						inputs.put(e.getKey(), (weeklyLimit - sum));
					} else {
						sum+=e.getValue();
						inputs.put(e.getKey(), e.getValue());
					}
				}
			}
		}
		
		return inputs;
	}

}
