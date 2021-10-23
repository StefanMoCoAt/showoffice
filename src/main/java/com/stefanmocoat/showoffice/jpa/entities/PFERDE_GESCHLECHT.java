package com.stefanmocoat.showoffice.jpa.entities;

public enum PFERDE_GESCHLECHT {

    HENGST("H"),
    STUTE("S"),
    WALLACH("W");

    String geschlecht;

    PFERDE_GESCHLECHT(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getGeschlecht() {
        return geschlecht;
    }
}
