package com.stefanmocoat.showoffice.jpa.entities.zns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Bei import aus ZNS (Richter01.DAT) entspricht dies dem Y-Satz.
 */
@Entity
public class ParcourBauer {

    @Id
    @GeneratedValue
    private long id;

    @Column
    // SATZNUMMER in ZNS
    private String znsId;

    @Column(length = 75)
    private String name;

    @Column(length = 30)
    private String qualifikationen;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZnsId() {
        return znsId;
    }

    public void setZnsId(String znsRichterId) {
        this.znsId = znsRichterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualifikationen() {
        return qualifikationen;
    }

    public void setQualifikationen(String qualifikationen) {
        this.qualifikationen = qualifikationen;
    }

}
