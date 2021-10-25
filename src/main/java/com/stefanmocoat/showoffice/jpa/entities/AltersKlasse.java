package com.stefanmocoat.showoffice.jpa.entities;

public enum AltersKlasse {

    JG("Jugendlicher"),
    JR("Junior"),
    U25("U25"),
    Y("Junger Reiter");

    String werte;

    AltersKlasse(String werte) {
        this.werte = werte;
    }
}
