package com.stefanmocoat.showoffice.jpa.entities;

public enum PFERDE_FARBE {

    RAPPE("Rappe"),
    FUCHS("Fuchs"),
    SCHIMMEL("Schimmel"),
    BRAUNER("Brauner");

    String pferde_farbe;

    PFERDE_FARBE(String pferde_farbe) {
        this.pferde_farbe = pferde_farbe;
    }

    public String getPferde_farbe() {
        return pferde_farbe;
    }
}
