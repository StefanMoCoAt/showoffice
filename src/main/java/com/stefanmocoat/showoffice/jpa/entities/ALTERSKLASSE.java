package com.stefanmocoat.showoffice.jpa.entities;

public enum ALTERSKLASSE {

    JG("Jugendlicher"),
    JR("Junior"),
    U25("U25"),
    Y("Junger Reiter");

    String werte;

    ALTERSKLASSE(String werte) {
        this.werte = werte;
    }
}
