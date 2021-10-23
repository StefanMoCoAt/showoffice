package com.stefanmocoat.showoffice.jpa.entities.zns;

public enum PFERDE_ABSTAMMUNG {

    OESTERREICHISCHES_WARMBLUT("Österr. WB"),
    WESTFALE("Westfale"),
    HANNOVERANER("Hannoveraner"),
    KWPN("KWPN"),
    ZANGERSHEIDE("Zangersheide"),
    HOLSTEINER("Holsteiner");

    String abstammung;

    PFERDE_ABSTAMMUNG(String abstammung) {
        this.abstammung = abstammung;
    }

    public String getAbstammung() {
        return abstammung;
    }
}
