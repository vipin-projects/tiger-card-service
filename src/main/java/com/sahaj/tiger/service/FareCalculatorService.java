package com.sahaj.tiger.service;

import java.util.List;

import com.sahaj.tiger.model.Journey;

//This interface defines the contract
public interface FareCalculatorService {
	Integer calculateFare(List<Journey> journeys);
}
