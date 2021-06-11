package com.sahaj.tiger.db.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fare")
public class Fare {
	@Id
	Integer id;
	@Column(name = "from_zone")
	private String fromZone;
	@Column(name = "to_zone")
	private String toZone;
	@Column(name = "peak_hours_charges")
	private Integer peakHoursCharges;
	@Column(name = "offpeak_hours_charges")
	private Integer offPeakHoursCharges;
	/**
	 * @return the fromZone
	 */
	public String getFromZone() {
		return fromZone;
	}
	/**
	 * @param fromZone the fromZone to set
	 */
	public void setFromZone(String fromZone) {
		this.fromZone = fromZone;
	}
	/**
	 * @return the toZone
	 */
	public String getToZone() {
		return toZone;
	}
	/**
	 * @param toZone the toZone to set
	 */
	public void setToZone(String toZone) {
		this.toZone = toZone;
	}
	/**
	 * @return the peakHoursCharges
	 */
	public Integer getPeakHoursCharges() {
		return peakHoursCharges;
	}
	/**
	 * @param peakHoursCharges the peakHoursCharges to set
	 */
	public void setPeakHoursCharges(Integer peakHoursCharges) {
		this.peakHoursCharges = peakHoursCharges;
	}
	/**
	 * @return the offPeakHoursCharges
	 */
	public Integer getOffPeakHoursCharges() {
		return offPeakHoursCharges;
	}
	/**
	 * @param offPeakHoursCharges the offPeakHoursCharges to set
	 */
	public void setOffPeakHoursCharges(Integer offPeakHoursCharges) {
		this.offPeakHoursCharges = offPeakHoursCharges;
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
