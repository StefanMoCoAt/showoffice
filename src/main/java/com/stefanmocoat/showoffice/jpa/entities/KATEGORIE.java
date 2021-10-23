package com.stefanmocoat.showoffice.jpa.entities;

public enum KATEGORIE {

	CDN_AA("CDN-A*"),
	CDN_A("CDN-A"),
	CDN_BB("CDN-B*"),
	CDN_B("CDN-B"),
	CDN_C("CDN-C"),
	CDN_C_NEU("CDN-C-NEU");

	final String name;

	private KATEGORIE(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
