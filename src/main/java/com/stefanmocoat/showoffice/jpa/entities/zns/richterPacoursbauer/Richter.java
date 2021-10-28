package com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Bei import aus ZNS (Richter01.DAT) entspricht dies dem X-Satz.
 */
@Entity
public class Richter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String richterId;

    @Column(length = 75)
    private String name;

    @OneToMany(mappedBy = "richter", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RichterQualAssignment> qualAssignments = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRichterId() {
        return richterId;
    }

    public void setRichterId(String znsRichterId) {
        this.richterId = znsRichterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RichterQualAssignment> getQualAssignments() {
        return qualAssignments;
    }

    public void setQualAssignments(List<RichterQualAssignment> qualAssignments) {
        this.qualAssignments = qualAssignments;
    }
}
