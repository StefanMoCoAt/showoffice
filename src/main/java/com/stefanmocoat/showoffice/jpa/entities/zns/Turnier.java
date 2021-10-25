package com.stefanmocoat.showoffice.jpa.entities.zns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * TURNIERBEZEICHNUNG A-SATZ OEPS Pflichtenhelft 2021 V2.4
 * n2-XXXXX.dat(Nenndaten)
 */
@Entity
public class Turnier {

	@Id
	@GeneratedValue
	private long id;

//	@Column(length = 1)
//	private String ID = "A";

	@Column(length = 5)
	private Integer TURNIERNR;

	@Column(length = 25)
	private String TURNIERNAME_ORT;

	@Column(length = 8)
	private Integer VON;

	@Column(length = 8)
	private Integer BIS;

	@Column(length = 25)
	private com.stefanmocoat.showoffice.jpa.entities.Kategorie KATEGORIE;

	public Turnier() {
	}

//	public String getID() {
//		return ID;
//	}
//
//	public void setID(String ID) {
//		this.ID = ID;
//	}

	public Integer getTURNIERNR() {
		return TURNIERNR;
	}

	public void setTURNIERNR(Integer TURNIERNR) {
		this.TURNIERNR = TURNIERNR;
	}

	public String getTURNIERNAME_ORT() {
		return TURNIERNAME_ORT;
	}

	public void setTURNIERNAME_ORT(String TURNIERNAME_ORT) {
		this.TURNIERNAME_ORT = TURNIERNAME_ORT;
	}

	public Integer getVON() {
		return VON;
	}

	public void setVON(Integer VON) {
		this.VON = VON;
	}

	public Integer getBIS() {
		return BIS;
	}

	public void setBIS(Integer BIS) {
		this.BIS = BIS;
	}

	public com.stefanmocoat.showoffice.jpa.entities.Kategorie getKATEGORIE() {
		return KATEGORIE;
	}

	public void setKATEGORIE(com.stefanmocoat.showoffice.jpa.entities.Kategorie KATEGORIE) {
		this.KATEGORIE = KATEGORIE;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	@Override
//	public String toString() {
//		final StringBuilder sb = new StringBuilder("TURIERBEZEICHNUNG{");
//		sb.append("turnierbezeichnung_ID=").append(id);
//		sb.append(", ID='").append(ID).append('\'');
//		sb.append(", TURNIERNR=").append(TURNIERNR);
//		sb.append(", TURNIERNAME_ORT='").append(TURNIERNAME_ORT).append('\'');
//		sb.append(", VON=").append(VON);
//		sb.append(", BIS=").append(BIS);
//		sb.append(", KATEGORIE=").append(KATEGORIE);
//		sb.append('}');
//		return sb.toString();
//	}

	// TODO Bewerbe Liste neu implementieren an geeigneter stelle
	/*
	 * @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch =
	 * FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "turnier_ID") private List<Bewerb> bewerbe = new
	 * ArrayList<>(); public List<Bewerb> getBewerbe() { return
	 * Collections.unmodifiableList(bewerbe); }
	 * 
	 * // ATTENTION - used for jackson marshalling - do not use internal public void
	 * setBewerbe(List<Bewerb> bewerbe) { this.bewerbe = bewerbe; }
	 * 
	 * public void addBewerb(Bewerb b) { bewerbe.add(b); }
	 * 
	 * public void removeBewerb(Bewerb b) { bewerbe.remove(b); }
	 */
}
