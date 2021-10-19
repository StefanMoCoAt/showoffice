package com.stefanmocoat.showoffice.jpa.entities;

public enum TurnierKategorie {

	CDN_C("Dressur C"), CDN_B("Dressur B"), CDN_A("Dressur A"), CSN_C("Springen C"), CSN_B("Springen B"),
	CSN_A("Springen A");

	final String name;

	private TurnierKategorie(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
