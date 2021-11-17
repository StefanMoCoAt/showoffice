package com.stefanmocoat.showoffice.jpa.entities;

public enum AltersKlasse {

    JUGENDLICH("JG"),
    JUNIOR("JR"),
    U25("25"),
    JUNGERREITER("Y");

    String werte;

    AltersKlasse(String werte) {
        this.werte = werte;
    }

    public String getWerte() {
        return werte;
    }

    public static AltersKlasse findByCode(String werte) {
        for (AltersKlasse akl : AltersKlasse.values()) {
            if (akl.getWerte().equals(werte)) {
                return akl;
            }
        }
        return null;
    }
}
