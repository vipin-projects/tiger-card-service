package com.sahaj.tiger.model;

public enum Zones {
	Zone1("Central Area"),
	Zone2("Concetric Ring");
	
	private String description;
	
	Zones(String desc) {
		description = desc;
	}
	
	public String getDescription() {
		return description;
	}
}
