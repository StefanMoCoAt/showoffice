package com.stefanmocoat.showoffice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;

import com.stefanmocoat.showoffice.jpa.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stefanmocoat.showoffice.service.PferdService;
import com.stefanmocoat.showoffice.service.PferdeFarbeService;
import com.stefanmocoat.showoffice.service.ReiterService;
import com.stefanmocoat.showoffice.service.TurnierService;
import com.stefanmocoat.showoffice.service.VereinService;
import com.stefanmocoat.showoffice.service.imports.ImportReiter;
import com.stefanmocoat.showoffice.service.imports.ImportRichterParcous;
import com.vaadin.flow.component.dependency.NpmPackage;

@SpringBootApplication
@NpmPackage(value = "lumo-css-framework", version = "^4.0.10")
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class ShowofficeApplication implements CommandLineRunner {

	static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

	/*
	 * @Autowired TurnierService tournierService;
	 */

	@Autowired
	ImportRichterParcous importRichterParcour;

	@Autowired
	ImportReiter importReiter;

	@Autowired
	VereinService vereinService;

	@Autowired
	PferdService pferdService;

	@Autowired
	PferdeFarbeService pferdeFarbeService;

	@Autowired
	ReiterService reiterService;

	@Autowired
	TurnierService turnierService;

	public static void main(String[] args) {
		SpringApplication.run(ShowofficeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		importVerein();

		importRichterParcour.doImport();
		importReiter.doImport();

		importPferd();
		
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

	private void importPferd() {

		PferdeGeschlecht pferdeGeschlecht;

		try (BufferedReader reader = new BufferedReader(new FileReader("zns_daten/PFERDE01_TEST.dat"))) {
			String line = reader.readLine();
			while (line != null) {
				String kopfNr = line.substring(0, 4);
				String name = line.substring(4, 34).trim();
				String lebensNr = line.substring(34, 43);

				String inGeschlecht = line.substring(43, 44);
				PferdeGeschlecht geschlecht = PferdeGeschlecht.findByCode(inGeschlecht);

				String gebJahr = line.substring(44, 48);
				String farbe = line.substring(48, 63).trim();
				String abstammung = line.substring(63, 78).trim();
				String vereinNr = line.substring(78, 82);
				String letzteZahlungJahr = line.substring(82, 86);
				String verantwortlichePerson = line.substring(86, 161).trim();
				String vater = line.substring(161, 191).trim();
				String feiPass = line.substring(191, 199).trim();
				String satzNr = line.substring(199).trim();

				addPferd(kopfNr, name, lebensNr, geschlecht, gebJahr, farbe,
						abstammung, vereinNr, letzteZahlungJahr, verantwortlichePerson, vater,
						feiPass, satzNr);
				line = reader.readLine();
			}
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	private PferdeFarbe addPferdFarbeIfNotExists(String farbe) {
		String trimmedQual = farbe.trim();
		PferdeFarbe pferdeFarbe = pferdeFarbeService.findByFarbe(farbe);
		if (pferdeFarbe == null) {
			pferdeFarbe = new PferdeFarbe();
			pferdeFarbe.setFarbe(trimmedQual);
			pferdeFarbeService.add(pferdeFarbe);
		}

		return pferdeFarbeService.findByFarbe(farbe);
	}

	private void addPferd(String kopfNr, String name, String lebensNr,
						  PferdeGeschlecht geschlecht, String gebJahr, String farbe, String abstammung,
						  String vereinNr, String letzteZahlungJahr, String verantwortlichePerson, String vater,
						  String feiPass, String satzNr) {

		Pferd pferd = pferdService.findByKopfnummer(kopfNr);

		boolean insert = false;
		if (pferd == null) {
			insert = true;
			pferd = new Pferd();
			pferd.setKopfnummer(kopfNr);
		}

		PferdeFarbe pfarbe = addPferdFarbeIfNotExists(farbe);
		Verein verein = vereinService.findByVereinId(vereinNr);

		pferd.setPferdename(name);
		pferd.setLebensnummer(lebensNr);

		pferd.setGeschlecht(geschlecht);

		pferd.setGebJahr(gebJahr);
		pferd.setFarbe(pfarbe);
		pferd.setAbstammung(abstammung);
		pferd.setVerein(verein);
		pferd.setLetzteZahlungJahr(letzteZahlungJahr);
		pferd.setVerantwortlichePerson(verantwortlichePerson);
		pferd.setVater(vater);
		pferd.setFeiPass(feiPass);
		pferd.setSatznummerDesPferdes(satzNr);

		if (insert) {
			pferdService.add(pferd);
		} else {
			pferdService.update(pferd);
		}
	}

	private void importVerein() {
		try {

			addKeinVerein();

			BufferedReader reader = new BufferedReader(new FileReader("zns_daten/VEREIN01_TEST.dat")); // ,
																										// Charset.forName("Cp850")
			String line = reader.readLine();
			while (line != null) {
				String vereinNr = line.substring(0, 4);
				String vereinName = line.substring(4).trim();

				addVerein(vereinNr, vereinName);
				line = reader.readLine();
			}
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	private void addKeinVerein() {
		// import 0000 Verein -> vereinslos
		Verein verein = vereinService.findByVereinId("0000");

		boolean insert = false;
		if (verein == null) {
			insert = true;
			verein = new Verein();
			verein.setVereinId("0000");
		}

		verein.setVereinName("kein Verein");

		if (insert) {
			vereinService.add(verein);
		} else {
			vereinService.update(verein);
		}
	}

	private void addVerein(String vereinNr, String vereinName) {

		Verein verein = vereinService.findByVereinId(vereinNr);

		boolean insert = false;
		if (verein == null) {
			insert = true;
			verein = new Verein();
			verein.setVereinId(vereinNr);
		}

		verein.setVereinName(vereinName);

		if (insert) {
			vereinService.add(verein);
		} else {
			vereinService.update(verein);
		}
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

//		try (BufferedReader reader = new BufferedReader(new FileReader("zns_daten/PFERDE01_TEST.dat"))) {
//			String line = reader.readLine();
//			while (line != null) {
//				String pferdKopfnummer = line.substring(0, 4);
//				String pferdPferdename = line.substring(4, 34).trim();
//				String pferdLebensnummer = line.substring(34, 43);
//				String pferdGeschlecht = line.substring(43, 44);
//				String pferdGebJahr = line.substring(44, 48);
//				String pferdFarbe = line.substring(48, 63).trim();
//				String pferdAbstammung = line.substring(63, 78).trim();
//				String pferdVereinNr = line.substring(78, 82);
//				String pferdLetzteZahlungJahr = line.substring(82, 86);
//				String pferdVerantwortlichePerson = line.substring(86, 161).trim();
//				String pferdVater = line.substring(161, 191).trim();
//				String pferdFeiPass = line.substring(191, 199).trim();
//				String pferdSatznummerDesPferdes = line.substring(199).trim();
//
//				addPferd(pferdKopfnummer, pferdPferdename, pferdLebensnummer, pferdGeschlecht, pferdGebJahr, pferdFarbe,
//						pferdAbstammung, pferdVereinNr, pferdLetzteZahlungJahr, pferdVerantwortlichePerson, pferdVater,
//						pferdFeiPass, pferdSatznummerDesPferdes);
//				line = reader.readLine();
//			}
//		} catch (IOException e) {
//			throw new IllegalStateException(e);
//		}
	}
}
