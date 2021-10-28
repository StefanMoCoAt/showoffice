package com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Bei import aus ZNS (Richter01.DAT) entspricht dies dem Y-Satz.
 */
@Entity
public class ParcoursBauer {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String parcousBauerId;

    @Column
    private String name;

    @OneToMany(mappedBy = "parcoursBauer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParcoursBauerQualAssignment> qualAssignments = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getParcousBauerId() {
        return parcousBauerId;
    }

    public void setParcousBauerId(String znsRichterId) {
        this.parcousBauerId = znsRichterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParcoursBauerQualAssignment> getQualAssignments() {
        return qualAssignments;
    }

    public void setQualAssignments(List<ParcoursBauerQualAssignment> qualAssignments) {
        this.qualAssignments = qualAssignments;
    }
}
