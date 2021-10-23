package com.stefanmocoat.showoffice;

import com.stefanmocoat.showoffice.jpa.entities.Bewerb;
import com.stefanmocoat.showoffice.jpa.entities.BewerbKlasse;
import com.stefanmocoat.showoffice.jpa.entities.KATEGORIE;
import com.stefanmocoat.showoffice.jpa.entities.zns.TURIERBEZEICHNUNG;
import com.stefanmocoat.showoffice.service.TurnierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShowofficeApplication implements CommandLineRunner {

	@Autowired
	TurnierService tournierService;

	public static void main(String[] args) {
		SpringApplication.run(ShowofficeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*TURIERBEZEICHNUNG t1 = new TURIERBEZEICHNUNG();
		t1.setName("Dressur");
		t1.setKategorie(KATEGORIE.CDN_C);

		Bewerb b1 = new Bewerb();
		b1.setName("Dressur A");
		b1.setKlasse(BewerbKlasse.KLASSE_A);
		t1.addBewerb(b1);

		Bewerb b2 = new Bewerb();
		b2.setName("Dressur L");
		b2.setKlasse(BewerbKlasse.KLASSE_L);
		t1.addBewerb(b2);

		tournierService.add(t1);

		TURIERBEZEICHNUNG t2 = new TURIERBEZEICHNUNG();
		t2.setName("Springen");
		t2.setKategorie(KATEGORIE.CSN_B);
		tournierService.add(t2);

		for (TURIERBEZEICHNUNG t : tournierService.findAll()) {
			System.out.println(t);
		}*/
	}

}
