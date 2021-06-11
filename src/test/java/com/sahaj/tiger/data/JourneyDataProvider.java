package com.sahaj.tiger.data;

import java.util.ArrayList;
import java.util.List;

import com.sahaj.tiger.model.Journey;
import com.sahaj.tiger.model.JourneysRequest;
import com.sahaj.tiger.model.Zones;

public class JourneyDataProvider {
	/**
	 * This method will return single Journey data
	 * @return
	 */
	public static JourneysRequest getSingleJourneyRequest() {
		//create journey object
		Journey journey = new Journey("Monday", "10:30", Zones.Zone1, Zones.Zone1);
		
		//add to list
		List<Journey> journeyList = new ArrayList<Journey>();
		journeyList.add(journey);
		
		//create request object
		JourneysRequest request = new JourneysRequest();
		//set journy list
		request.setJourneys(journeyList);
		//return
		return request;
	}
	
	/**
	 * It will create the multiple journey data
	 * @return
	 */
	public static JourneysRequest getMultipleJourneyRequest() {
		//create journey object
		Journey journey = new Journey("Monday", "10:30", Zones.Zone1, Zones.Zone1);
		Journey journey1 = new Journey("Tuesday", "10:30", Zones.Zone1, Zones.Zone1);
		
		//add to list
		List<Journey> journeyList = new ArrayList<Journey>();
		journeyList.add(journey);
		journeyList.add(journey1);
		
		//create request object
		JourneysRequest request = new JourneysRequest();
		//set journy list
		request.setJourneys(journeyList);
		//return
		return request;
	}
	
	public static JourneysRequest getMultipleDaysJourneyRequest(Zones zone) {
		//create journey object
		Journey journey = new Journey("Monday", "11:30", zone, zone);
		Journey journey1 = new Journey("Tuesday", "12:30", zone, zone);
		Journey journey2 = new Journey("Wednesday", "11:30", zone, zone);
		Journey journey3 = new Journey("Thursday", "12:30", zone, zone);
		Journey journey4 = new Journey("Friday", "11:30", zone, zone);
		Journey journey5 = new Journey("Saturday", "12:30", zone, zone);
		Journey journey6 = new Journey("Monday", "11:30", zone, zone);
		Journey journey7 = new Journey("Tuesday", "12:30", zone, zone);
		Journey journey8 = new Journey("Sunday", "11:30", zone, zone);
		Journey journey9 = new Journey("Tuesday", "12:30", zone, zone);
		//add to list
		List<Journey> journeyList = new ArrayList<Journey>();
		journeyList.add(journey);
		journeyList.add(journey1);
		journeyList.add(journey2);
		journeyList.add(journey3);
		journeyList.add(journey4);
		journeyList.add(journey5);
		journeyList.add(journey6);
		journeyList.add(journey7);
		journeyList.add(journey8);
		journeyList.add(journey9);
		
		//create request object
		JourneysRequest request = new JourneysRequest();
		//set journy list
		request.setJourneys(journeyList);
		//return
		return request;
	}
	
	public static JourneysRequest getAskedJourneyRequestAsInput(Zones zone) {
		//create journey object
		Journey journey = new Journey("Monday", "10:20", Zones.Zone2, Zones.Zone1);
		Journey journey1 = new Journey("Monday", "10:45", zone, zone);
		Journey journey2 = new Journey("Monday", "16:15", zone, zone);
		Journey journey3 = new Journey("Monday", "18:15", zone, zone);
		Journey journey4 = new Journey("Monday", "19:00", Zones.Zone1, Zones.Zone2);
		
		//add to list
		List<Journey> journeyList = new ArrayList<Journey>();
		journeyList.add(journey);
		journeyList.add(journey1);
		journeyList.add(journey2);
		journeyList.add(journey3);
		journeyList.add(journey4);
		//create request object
		JourneysRequest request = new JourneysRequest();
		//set journy list
		request.setJourneys(journeyList);
		//return
		return request;
	}
}
