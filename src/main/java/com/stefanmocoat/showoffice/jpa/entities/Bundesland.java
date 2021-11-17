package com.stefanmocoat.showoffice.jpa.entities;

public enum Bundesland {

    UNBEKANNT("00", "UNBEKANNT"),
    WIEN("01", "WIEN"),
    NIEDEROESTERREICH("02", "NIEDEROESTERREICH"),
    BURGENLAND("03", "BURGENLAND"),
    STEIERMARK("04", "STEIERMARK"),
    KAERNTEN("05", "KAERNTEN"),
    OBEROESTERREICH("06", "OBEROESTERREICH"),
    SALZBURG("07", "SALZBURG"),
    TIROL("08", "TIROL"),
    VORARLBERG("09", "VORARLBERG");

    String laedercode;
    String land;

    Bundesland(String laedercode, String land) {
        this.laedercode = laedercode;
        this.land = land;
    }

    public String getLaedercode() {
        return laedercode;
    }

    public String getLand() {
        return land;
    }

    public static Bundesland findByCode(String laedercode) {
        for (Bundesland b : Bundesland.values()) {
            if (b.getLaedercode().equals(laedercode)) {
                return b;
            }
        }
        return null;
    }

    public static Bundesland findByLand(String land) {
        for (Bundesland b: Bundesland.values()) {
            if (b.getLand().equals(land)) {
                return b;
            }
        }
        return null;
    }
}
