package com.sahaj.tiger.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahaj.tiger.db.entity.CappingLimit;
import com.sahaj.tiger.db.entity.Fare;
import com.sahaj.tiger.db.entity.OffPeakHours;
import com.sahaj.tiger.db.entity.PeakHours;
import com.sahaj.tiger.db.repository.CapLimitRepository;
import com.sahaj.tiger.db.repository.FareRepository;
import com.sahaj.tiger.db.repository.OffPeakHoursRepository;
import com.sahaj.tiger.db.repository.PeakHoursRepository;
import com.sahaj.tiger.factory.FareCalculator;
import com.sahaj.tiger.factory.FareCalculatorFactory;
import com.sahaj.tiger.model.Journey;
import com.sahaj.tiger.model.Zones;
import com.sahaj.tiger.utility.TimeUtility;

@Service
public class FareCalculatorServiceImpl implements FareCalculatorService {
	@Autowired
	OffPeakHoursRepository offPeakRepository;
	@Autowired
	PeakHoursRepository peakHoursRepository;
	@Autowired
	FareRepository fareRepository;
	@Autowired
	CapLimitRepository capLimitRepository;
	
	/**
	 * This method will calculate the fare based on the input journeys
	 */
	@Override
	public Integer calculateFare(List<Journey> journeys) {
		//initialise sum to 0
		Integer sum = 0;
		
		//fetch peak hours details
		List<PeakHours> peakHours = peakHoursRepository.findAll();
		//iterate over each journey
		Map<String, Integer> journeyMap = new HashMap<String, Integer>();
		for (Journey journey : journeys) {
			convertZoneInfo(journey);
			//check if start and end points are the same
			if(journey.getFromZone().compareTo(journey.getToZone()) == 0) {
				if(!journeyMap.containsKey(journey.getDay()))
					journeyMap.put(journey.getDay(), calculateForSameOriginJourney(sum, peakHours, journey));
				else {
					Integer f = journeyMap.get(journey.getDay());
					journeyMap.put(journey.getDay(), calculateForSameOriginJourney(sum, peakHours, journey)+f);
				}
			} else {
				if(!journeyMap.containsKey(journey.getDay()))
					journeyMap.put(journey.getDay(), calculateForDiffOriginJourney(sum, peakHours, journey));
				else {
					Integer f = journeyMap.get(journey.getDay());
					journeyMap.put(journey.getDay(), calculateForDiffOriginJourney(sum, peakHours, journey)+f);
				}
			}
		}
		//return the total fare
		return calculateTotalFare(journeyMap, journeys.get(0).getFromZoneStr(), journeys.get(0).getToZoneStr());
	}
	
	/**
	 * This method will calculate total fare based on journey map and zone information.
	 * @param journeyMap
	 * @param fromZone
	 * @param toZone
	 * @return
	 */
	private Integer calculateTotalFare(Map<String, Integer> journeyMap, String fromZone, String toZone) {
			CappingLimit cappingLimit = capLimitRepository.fetchCappingLimit(fromZone, toZone);
			
			//initialise the FareCalculator with daily/weekly instance
			FareCalculator calculator = null;
			if(journeyMap.size() == 1) 
				calculator = FareCalculatorFactory.getInstance("daily");
			else	
				calculator = FareCalculatorFactory.getInstance("weekly");
			
			//invoke the FareCalcualtor instance to calculate the fare.
			Map<String, Integer> output = calculator.calculateTotalFare(journeyMap, cappingLimit.getDailyCap(), cappingLimit.getWeeklyCap());
			return output.values().stream().reduce(0, Integer::sum);
	}
	
	/**
	 * This method will set zone in numeric format.
	 * @param journey
	 */
	private void convertZoneInfo(Journey journey) {
		if(journey.getFromZone().equals(Zones.Zone1))
			journey.setFromZoneStr("1");
		else 
			journey.setFromZoneStr("2");
		if(journey.getToZone().equals(Zones.Zone1))
			journey.setToZoneStr("1");
		else 
			journey.setToZoneStr("2");
	}
	
	/**
	 * This method will calculate fare for same origin journey.
	 * @param sum
	 * @param peakHours
	 * @param journey
	 * @return
	 */
	private Integer calculateForSameOriginJourney(Integer sum, List<PeakHours> peakHours, Journey journey) {
		Boolean peakHoursFlag = Boolean.FALSE;
		//check if journey is in peak hours
		peakHoursFlag = isJourneyInPeakHours(journey.getDay(), journey.getTime(), peakHours);
		
		//fetch fare details
		Fare fare = fareRepository.fetchFare(journey.getFromZoneStr(), journey.getToZoneStr());
		
		//return the fare
		return getFare(peakHoursFlag, fare);
	}
	
	/**
	 * This method will calculate fare for different origin journey
	 * @param sum
	 * @param peakHours
	 * @param journey
	 * @return
	 */
	private Integer calculateForDiffOriginJourney(Integer sum, List<PeakHours> peakHours, Journey journey) {
		Boolean peakHoursFlag = Boolean.FALSE;
		
		//check if journey is in peak hours
		peakHoursFlag = isJourneyInPeakHours(journey.getDay(), journey.getTime(), peakHours);
		
		//check if journey in off peak hours - in case start/end are in different zones
		peakHoursFlag = isJourneyInOffPeakHours(journey);
		
		Fare fare = fareRepository.fetchFare(journey.getFromZoneStr(), journey.getToZoneStr());
		
		//return the fare
		return getFare(peakHoursFlag, fare);
	}
	
	private Boolean isJourneyInOffPeakHours(Journey journey) {
		//fetch off peak hours details 
		List<OffPeakHours> offPeakHours = offPeakRepository.findAll();
		
		//filter the off peak data
		List<String> offPeakHoursFilter = offPeakHours.stream()
		.filter(p-> p.getDay().equals(journey.getDay()))
		.filter(p-> p.getFromZone() == Integer.parseInt(journey.getFromZoneStr())
				&& p.getToZone() == Integer.parseInt(journey.getToZoneStr()))
		.filter(p-> TimeUtility.checkIfGivenTimeBelongInPeakHours(journey.getTime(), p.getStartTime(), p.getEndTime()))
		.map(p->p.getDay())
		.collect(Collectors.toList());
		
		//return as peak if no data in off peak
		return (offPeakHoursFilter == null || offPeakHoursFilter.isEmpty()) ? true : false;
	}
	
	/**
	 * This method will return fare based on peak hour flag.
	 * @param peakHoursFlag
	 * @param fare
	 * @return
	 */
	private Integer getFare(Boolean peakHoursFlag, Fare fare) {
		if(peakHoursFlag)
			return fare.getPeakHoursCharges();
		else
			return fare.getOffPeakHoursCharges();
	}
	
	/**
	 * This method will check if journey is in peak hours.
	 * @param day
	 * @param time
	 * @param peakHours
	 * @return
	 */
	private Boolean isJourneyInPeakHours(String day, String time, List<PeakHours> peakHours) {
		List<Integer> peakHoursFilter = peakHours.stream()
		.filter(p-> p.getDay().equals(day))
		.filter(p-> TimeUtility.checkIfGivenTimeBelongInPeakHours(time, p.getStartTime(), p.getEndTime()))
		.map(p-> p.getId())
		.collect(Collectors.toList());
		
		return (peakHoursFilter == null || peakHoursFilter.isEmpty()) ? false : true;
	}

}
