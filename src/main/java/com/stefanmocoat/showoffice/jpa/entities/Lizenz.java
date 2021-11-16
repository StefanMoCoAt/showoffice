package com.stefanmocoat.showoffice.jpa.entities;

/**
 * Reiterlizenzen, § 15 ÖTO
 */
public enum Lizenz {

    R1("R1"), R2("R2"), R3("R3"),
    RD1("RD1"), RD2("RD2"), RD3("RD3"), RD4("RD4"),
    R1D2("R1D2"), R1D3("R1D3"), R2D3("R2D3"), R1D4("R1D4"), R2D4("R2D4"), R3D4("R3D4"), RDS4("RDS4"),
    R1S2("R1S2"), R1S3("R1S3"), R1S4("R1S4"),
    R2S3("R2S3"), R2S4("R2S4"), R3S4("R3S4"),
    F1("F1"), F2("F2"),
    WE1("WE1"), WE2("WE2");


    String code;

    Lizenz(String lizenz) {
        this.code = lizenz;
    }

    public String getCode() {
        return code;
    }

    public static Lizenz findByCode(String code) {
        for (Lizenz l : Lizenz.values()) {
            if (l.getCode().equals(code.trim())) {
                return l;
            }
        }
        return null;
    }
}
