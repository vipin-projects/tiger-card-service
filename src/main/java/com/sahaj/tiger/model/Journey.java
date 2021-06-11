package com.sahaj.tiger.model;

//this is model class for Journey
public class Journey {
	private String day;
	private String time;
	private Zones fromZone;
	private Zones toZone;
	private String fromZoneStr;
	private String toZoneStr;
	
	public Journey() {
		
	}
	
	public Journey(String day, String time, Zones fromZone, Zones toZone) {
		this.day = day;
		this.time = time;
		this.fromZone = fromZone;
		this.toZone = toZone;
	}
	
	/**
	 * @return the fromZoneStr
	 */
	public String getFromZoneStr() {
		return fromZoneStr;
	}
	/**
	 * @param fromZoneStr the fromZoneStr to set
	 */
	public void setFromZoneStr(String fromZoneStr) {
		this.fromZoneStr = fromZoneStr;
	}
	/**
	 * @return the toZoneStr
	 */
	public String getToZoneStr() {
		return toZoneStr;
	}
	/**
	 * @param toZoneStr the toZoneStr to set
	 */
	public void setToZoneStr(String toZoneStr) {
		this.toZoneStr = toZoneStr;
	}
	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the fromZone
	 */
	public Zones getFromZone() {
		return fromZone;
	}
	/**
	 * @param fromZone the fromZone to set
	 */
	public void setFromZone(Zones fromZone) {
		this.fromZone = fromZone;
	}
	/**
	 * @return the toZone
	 */
	public Zones getToZone() {
		return toZone;
	}
	/**
	 * @param toZone the toZone to set
	 */
	public void setToZone(Zones toZone) {
		this.toZone = toZone;
	}
	
	
}
