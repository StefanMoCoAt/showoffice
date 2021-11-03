package com.stefanmocoat.showoffice.jpa.entities;

import javax.persistence.*;

@Entity
public class Verein extends AbstractEntity {

    @Column(length = 4)
    private String vereinId;

    @Column(length = 50)
    private String vereinName;

    public String getVereinId() {
        return vereinId;
    }

    public void setVereinId(String vereinNr) {
        this.vereinId = vereinNr;
    }

    public String getVereinName() {
        return vereinName;
    }

    public void setVereinName(String vereinName) {
        this.vereinName = vereinName;
    }
}
