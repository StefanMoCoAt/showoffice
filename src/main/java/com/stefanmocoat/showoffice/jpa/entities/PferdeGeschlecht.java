package com.stefanmocoat.showoffice.jpa.entities;

public enum PferdeGeschlecht {

    HENGST("H"),
    STUTE("S"),
    WALLACH("W");

    String code;

    PferdeGeschlecht(String geschlecht) {
        this.code = geschlecht;
    }

    public String getCode() {
        return code;
    }

    public static PferdeGeschlecht findByCode(String code) {
        for (PferdeGeschlecht g : PferdeGeschlecht.values()) {
            if (g.getCode().equals(code.trim())) {
                return g;
            }
        }
        return null;
    }
}
