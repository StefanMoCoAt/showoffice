package com.stefanmocoat.showoffice.jpa.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Turnier {

	@Id
	@GeneratedValue
	private int id;

	@Column(length = 60)
	private String name;

	private TurnierKategorie kategorie;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "turnier_id")
	private List<Bewerb> bewerbe = new ArrayList<>();

	public Turnier() {
		// required by JPA
	}

	public Turnier(String name, TurnierKategorie kategorie) {
		this.name = name;
		this.kategorie = kategorie;
	}

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

	public TurnierKategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(TurnierKategorie kategorie) {
		this.kategorie = kategorie;
	}

	public List<Bewerb> getBewerbe() {
		return Collections.unmodifiableList(bewerbe);
	}

	// ATTENTION - used for jackson marshalling - do not use internal
	public void setBewerbe(List<Bewerb> bewerbe) {
		this.bewerbe = bewerbe;
	}

	public void addBewerb(Bewerb b) {
		bewerbe.add(b);
	}

	public void removeBewerb(Bewerb b) {
		bewerbe.remove(b);
	}

	@Override
	public String toString() {
		return "Turnier [id=" + id + ", name=" + name + ", kategorie=" + kategorie + ", bewerbe=" + bewerbe + "]";
	}

}
