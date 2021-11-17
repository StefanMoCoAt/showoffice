package com.stefanmocoat.showoffice;

import com.stefanmocoat.showoffice.jpa.entities.*;
import com.stefanmocoat.showoffice.service.PferdService;
import com.stefanmocoat.showoffice.service.ReiterService;
import com.stefanmocoat.showoffice.service.TurnierService;
import com.stefanmocoat.showoffice.service.VereinService;
import com.stefanmocoat.showoffice.service.imports.ImportPferde;
import com.stefanmocoat.showoffice.service.imports.ImportReiter;
import com.stefanmocoat.showoffice.service.imports.ImportRichterParcous;
import com.stefanmocoat.showoffice.service.imports.ImportVerein;
import com.vaadin.flow.component.dependency.NpmPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
@NpmPackage(value = "lumo-css-framework", version = "^4.0.10")
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class ShowofficeApplication implements CommandLineRunner {

	static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

	/*
	 * @Autowired TurnierService tournierService;
	 */

	// ZNS-Listen Importe
	@Autowired
	ImportVerein importVerein;

	@Autowired
	ImportRichterParcous importRichterParcour;

	@Autowired
	ImportPferde importPferde;

	@Autowired
	ImportReiter importReiter;

	// Service
	@Autowired
	VereinService vereinService;

	@Autowired
	ReiterService reiterService;

	@Autowired
	PferdService pferdService;

	@Autowired
	TurnierService turnierService;

	public static void main(String[] args) {
		SpringApplication.run(ShowofficeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		importVerein.doImport();
		importRichterParcour.doImport();
		importPferde.doImport();
		importReiter.doImport();
		
		importTurnier();

		/*
		 * TURIERBEZEICHNUNG t1 = new TURIERBEZEICHNUNG(); t1.setName("Dressur");
		 * t1.setKategorie(KATEGORIE.CDN_C);
		 *
		 * Bewerb b1 = new Bewerb(); b1.setName("Dressur A");
		 * b1.setKlasse(BewerbKlasse.KLASSE_A); t1.addBewerb(b1);
		 *
		 * Bewerb b2 = new Bewerb(); b2.setName("Dressur L");
		 * b2.setKlasse(BewerbKlasse.KLASSE_L); t1.addBewerb(b2);
		 *
		 * tournierService.add(t1);
		 *
		 * TURIERBEZEICHNUNG t2 = new TURIERBEZEICHNUNG(); t2.setName("Springen");
		 * t2.setKategorie(KATEGORIE.CSN_B); tournierService.add(t2);
		 *
		 * for (TURIERBEZEICHNUNG t : tournierService.findAll()) {
		 * System.out.println(t); }
		 */
	}

	private void importTurnier() {

		Turnier t = new Turnier();
		t.setNumber("123456789");
		t.setName("Test");
		t.setOrt("Wien");
		t.getKategorien().add(Kategorie.CDN_A);
		t.getKategorien().add(Kategorie.CDN_B);

		Bewerb b1 = new Bewerb();
		b1.setName("B1");

		Bewerb b2 = new Bewerb();
		b2.setName("B2");

		t.getBewerbe().add(b1);
		t.getBewerbe().add(b2);

		Pferd pferd = pferdService.findByKopfnummer("9D56");
		Reiter reiter = reiterService.findBySatzNrReiter("010016");
		Paarung p1 = new Paarung();
		p1.setPferd(pferd);
		p1.setReiter(reiter);

		b1.getPaarungen().add(p1);

		turnierService.add(t);

		Turnier t2 = turnierService.findByNumber(t.getNumber());

		System.out.println(t2);

	}
}
