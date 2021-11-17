package com.stefanmocoat.showoffice.jpa.entities;

public enum ReiterGeschlecht {

    MAENLICH("M"),
    WEIBLICH("W");

    String code;

    ReiterGeschlecht(String lizenz) {
        this.code = lizenz;
    }

    public String getCode() {
        return code;
    }

    public static ReiterGeschlecht findByCode(String code) {
        for (ReiterGeschlecht l : ReiterGeschlecht.values()) {
            if (l.getCode().equals(code.trim())) {
                return l;
            }
        }
        return null;
    }
}
