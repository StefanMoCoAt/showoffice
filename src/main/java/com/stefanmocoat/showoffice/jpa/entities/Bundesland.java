package com.stefanmocoat.showoffice.jpa.entities;

public enum Bundesland {

    WIEN("01"),
    NIEDEROESTERREICH("02"),
    BURGENLAND("03"),
    STEIERMARK("04"),
    KAERNTEN("05"),
    OBEROESTERREICH("06"),
    SALZBURG("07"),
    TIROL("08"),
    VORARLBERG("09"),
    UNBEKANNT("00");

    String laedercode;

    Bundesland(String laedercode) {
        this.laedercode = laedercode;
    }

    public String getLaedercode() {
        return laedercode;
    }
}
