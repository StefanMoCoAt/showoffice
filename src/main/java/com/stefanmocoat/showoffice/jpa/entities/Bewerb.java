package com.stefanmocoat.showoffice.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bewerb {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 60)
    private String name;

    private BewerbKlasse klasse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BewerbKlasse getKlasse() {
        return klasse;
    }

    public void setKlasse(BewerbKlasse klasse) {
        this.klasse = klasse;
    }

    @Override
    public String toString() {
        return "Bewerb [id=" + id + ", name=" + name + ", klasse=" + klasse + "]";
    }

}
