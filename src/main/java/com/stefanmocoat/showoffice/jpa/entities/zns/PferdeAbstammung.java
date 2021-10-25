package com.stefanmocoat.showoffice.jpa.entities.zns;

public enum PferdeAbstammung {

    OESTERREICHISCHES_WARMBLUT("Österr. WB"),
    WESTFALE("Westfale"),
    HANNOVERANER("Hannoveraner"),
    KWPN("KWPN"),
    ZANGERSHEIDE("Zangersheide"),
    HOLSTEINER("Holsteiner");

    String abstammung;

    PferdeAbstammung(String abstammung) {
        this.abstammung = abstammung;
    }

    public String getAbstammung() {
        return abstammung;
    }
}
