package com.stefanmocoat.showoffice.jpa.entities;

public enum BewerbKlasse {

	KLASSE_A("Klasse A"), KLASSE_L("Klasse L");
	
	final String name;

	private BewerbKlasse(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
