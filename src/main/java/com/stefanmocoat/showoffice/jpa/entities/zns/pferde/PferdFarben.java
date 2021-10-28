package com.stefanmocoat.showoffice.jpa.entities.zns.pferde;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Bei import aus ZNS (Richter01.DAT) entspricht dies dem X-Satz.
 */
@Entity
public class PferdFarben {

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

    public String getName() {
        return farbe;
    }

    public void setName(String name) {
        this.farbe = name;
    }

}
