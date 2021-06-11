package com.sahaj.tiger.utility;
import java.time.LocalTime;

public class TimeUtility {
	
	public static Boolean checkIfGivenTimeBelongInPeakHours(String input, String startTime, String endTime) {
		//Convert it into LocalTime
		LocalTime target = LocalTime.parse(input);
		
		//if input time is start time
		if(input.equals(startTime))
			return Boolean.TRUE;

		//check if input time is between startTime and endTime
		return (target.isAfter((LocalTime.parse(startTime))) 
		&& 
		target.isBefore(LocalTime.parse(endTime)));	
	}
	
}
