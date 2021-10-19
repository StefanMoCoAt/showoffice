package com.stefanmocoat.showoffice.stuff;

import org.junit.jupiter.api.Test;

import com.stefanmocoat.showoffice.jpa.entities.Bewerb;
import com.stefanmocoat.showoffice.jpa.entities.BewerbKlasse;
import com.stefanmocoat.showoffice.jpa.entities.Turnier;
import com.stefanmocoat.showoffice.jpa.entities.TurnierKategorie;

public class TurnierTest {

	@Test
	public void testTurnier() {
		Turnier t = new Turnier("Springen", TurnierKategorie.CDN_A);

		Bewerb bewerb1 = new Bewerb();
		bewerb1.setName("Springen");
		bewerb1.setKlasse(BewerbKlasse.KLASSE_A);

		Bewerb bewerb2 = new Bewerb();
		bewerb2.setName("Springen");
		bewerb2.setKlasse(BewerbKlasse.KLASSE_L);

		t.addBewerb(bewerb1);
		t.addBewerb(bewerb2);

		System.out.println(t.toString());
	}
}
