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
        switch (werte.trim()) {
            case "JG":
                return AltersKlasse.JUGENDLICH;
            case "JR":
                return AltersKlasse.JUNIOR;
            case "25":
                return AltersKlasse.U25;
            case "Y":
                return AltersKlasse.JUNGERREITER;
            default:
                return null;
        }
    }
}
