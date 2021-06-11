package com.sahaj.tiger.model;

import java.util.ArrayList;
import java.util.List;

//This is request model for multiple journeys
public class JourneysRequest {
	List<Journey> journeys = new ArrayList<Journey>();

	/**
	 * @return the journeys
	 */
	public List<Journey> getJourneys() {
		return journeys;
	}

	/**
	 * @param journeys the journeys to set
	 */
	public void setJourneys(List<Journey> journeys) {
		this.journeys = journeys;
	}
	
}
