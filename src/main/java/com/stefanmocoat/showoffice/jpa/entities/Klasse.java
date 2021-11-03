package com.stefanmocoat.showoffice.jpa.entities;

public enum Klasse {

    A("A"), L("L");

    final String name;

    private Klasse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
