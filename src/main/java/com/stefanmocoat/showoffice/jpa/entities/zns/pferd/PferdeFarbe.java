package com.stefanmocoat.showoffice.jpa.entities.zns.pferd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Bei import aus ZNS (Richter01.DAT) entspricht dies dem X-Satz.
 */
@Entity
public class PferdeFarbe {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String farbe;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String name) {
        this.farbe = name;
    }

}
