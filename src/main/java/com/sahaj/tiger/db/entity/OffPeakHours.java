package com.sahaj.tiger.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "off_peak_hours", schema="public")
public class OffPeakHours {
	@Id
	Integer id;
	@Column
	private String day;
	@Column(name="start_time")
	private String startTime;
	@Column(name="end_time")
	private String endTime;
	@Column(name="from_zone")
	private int fromZone;
	@Column(name="to_zone")
	private int toZone;
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
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the fromZone
	 */
	public int getFromZone() {
		return fromZone;
	}
	/**
	 * @param fromZone the fromZone to set
	 */
	public void setFromZone(int fromZone) {
		this.fromZone = fromZone;
	}
	/**
	 * @return the toZone
	 */
	public int getToZone() {
		return toZone;
	}
	/**
	 * @param toZone the toZone to set
	 */
	public void setToZone(int toZone) {
		this.toZone = toZone;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
}
