package com.sahaj.tiger.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "capping_limits")
public class CappingLimit {
	@Id
	Integer id;
	@Column(name = "from_zone")
	private String fromZone;
	@Column(name = "to_zone")
	private String toZone;
	@Column(name = "daily_cap")
	private Integer dailyCap;
	@Column(name = "weekly_cap")
	private Integer weeklyCap;
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
	public Integer getDailyCap() {
		return dailyCap;
	}
	/**
	 * @param peakHoursCharges the peakHoursCharges to set
	 */
	public void setDailyCap(Integer dailyCap) {
		this.dailyCap = dailyCap;
	}
	/**
	 * @return the offPeakHoursCharges
	 */
	public Integer getWeeklyCap() {
		return weeklyCap;
	}
	/**
	 * @param offPeakHoursCharges the offPeakHoursCharges to set
	 */
	public void setWeeklyCap(Integer weeklyCap) {
		this.weeklyCap = weeklyCap;
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
