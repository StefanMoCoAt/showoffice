package com.stefanmocoat.showoffice.jpa.entities;

public enum PferdeGeschlecht {

    HENGST("H"),
    STUTE("S"),
    WALLACH("W");

    String geschlecht;

    PferdeGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getGeschlecht() {
        return geschlecht;
    }
}
