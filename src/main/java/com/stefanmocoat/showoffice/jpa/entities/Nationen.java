package com.stefanmocoat.showoffice.jpa.entities;

public enum Nationen {

    AUSTRIA("AUT"),
    GERMAN("GER"),
    SWEDEN("SWE"),
    SLOWAKIA("SVK"),
    RUSSIA("RUS"),
    FINLAND("FIN"),
    CZECH_REPUBLIC("CZE");

    String kurz;

    Nationen(String kurz) {
        this.kurz = kurz;
    }

    public String getKurz() {
        return kurz;
    }

    public static Nationen findByKurz(String kurz) {
        for (Nationen n : Nationen.values()) {
            if (n.getKurz().equals(kurz.trim())) {
                return n;
            }
        }
        return null;
    }
}
