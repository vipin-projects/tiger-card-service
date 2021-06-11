package com.sahaj.tiger.factory;

import java.util.Map;

/**
 * This interface defines the contract for daily, weekly calculation.
 * It can be extended in future.
 * @author Vipin
 *
 */
public interface FareCalculator {
	Map<String, Integer> calculateTotalFare(Map<String, Integer> inputs, Integer dailyLimit, Integer weeklyLimit);
}
