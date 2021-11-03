package com.stefanmocoat.showoffice.jpa.entities;

public enum Kategorie {

	CDN_AA("CDN-A*"),
    CDN_A("CDN-A"),
    CDN_BB("CDN-B*"),
    CDN_B("CDN-B"),
    CDN_C("CDN-C"),
    CDN_C_NEU("CDN-C-NEU");

    final String name;

    private Kategorie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
