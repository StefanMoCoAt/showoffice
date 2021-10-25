package com.stefanmocoat.showoffice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stefanmocoat.showoffice.jpa.entities.zns.ParcourBauer;
import com.stefanmocoat.showoffice.jpa.entities.zns.Richter;
import com.stefanmocoat.showoffice.jpa.entities.zns.RichterQualAssignment;
import com.stefanmocoat.showoffice.jpa.entities.zns.RichterQualifikation;
import com.stefanmocoat.showoffice.service.ParcourBauerService;
import com.stefanmocoat.showoffice.service.RichterQualifikationService;
import com.stefanmocoat.showoffice.service.RichterService;
import com.stefanmocoat.showoffice.service.TurnierService;

@SpringBootApplication
public class ShowofficeApplication implements CommandLineRunner {

	static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

	@Autowired
	TurnierService tournierService;

	@Autowired
	RichterService richterService;

	@Autowired
	ParcourBauerService parcourBauerService;

	@Autowired
	RichterQualifikationService richterQualService;

	public static void main(String[] args) {
		SpringApplication.run(ShowofficeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// hier importieren wir manuell die Datei Richter.dat
		importRichterAndParcourBauer();

		// do some tests
		Richter r1 = richterService.findByZnsId("010068");
		System.out.println(r1.getAge());
		
		
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

	private void importRichterAndParcourBauer() {
//		File file = new File("C:\\Work\\Projects\\showoffice\\git\\showoffice\\src\\main\\resources\\import\\RICHT01.dat");
//		
//		if(!file.exists()) {
//			return;
//		}

		try (BufferedReader reader = new BufferedReader(
				new FileReader("src/main/resources/import/RICHT01.dat", Charset.forName("UTF-8")))) {
			String line = reader.readLine();
			while (line != null) {
				String satzNr = line.substring(0, 1);
				String znsId = line.substring(1, 7);
				String name = line.substring(7, 82).trim();
				String qualVal = line.substring(82).trim();
				String[] quals = qualVal.split(",");

				if (satzNr.equals("X")) {
					addRichterQualsIfNotExists(quals);
					addRichter(znsId, name, quals);
				} else if (satzNr.equals("Y")) {
					addParcourBauer(znsId, name, quals);
				}

				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}

	}

	private void addRichterQualsIfNotExists(String[] quals) {
		for (String qual : quals) {
			String trimmedQual = qual.trim();
			RichterQualifikation richterQual = richterQualService.findByName(trimmedQual);
			if (richterQual == null) {
				richterQual = new RichterQualifikation();
				richterQual.setName(trimmedQual);
				richterQualService.add(richterQual);
			}
		}
	}

	private void addParcourBauer(String znsId, String name, String[] quals) {
		ParcourBauer parcourBauer = parcourBauerService.findByZnsId(znsId);

		boolean insert = false;
		if (parcourBauer == null) {
			insert = true;
			parcourBauer = new ParcourBauer();
			parcourBauer.setZnsId(znsId);
		}

		parcourBauer.setName(name);
//		parcourBauer.setQualifikationen(quals);

		if (insert) {
			parcourBauerService.add(parcourBauer);
		} else {
			parcourBauerService.update(parcourBauer);
		}
	}

	private void addRichter(String znsId, String name, String[] quals) {

		// QUERY to find all richter + quals
//		SELECT R.NAME, RQ.name FROM RICHTER AS R
//		JOIN RICHTER_QUAL_ASSIGNMENT AS RQA ON RQA.RICHTER_ID  = R.ID 
//		JOIN RICHTER_QUALIFIKATION AS RQ ON RQ.ID = RQA.QUALIFIKATION_ID
//
//		order by R.name 

		Date birthDay = new Date();
		try {
			birthDay = DATE_FORMAT.parse("25.10.2001");
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}

		Richter richter = richterService.findByZnsId(znsId);

		boolean insert = false;
		if (richter == null) {
			insert = true;
			richter = new Richter();
			richter.setZnsId(znsId);
		}

		richter.setName(name);
		richter.setBirthday(birthDay);

		richter.getQualAssignments().clear();
		for (String qual : quals) {
			String trimmedQual = qual.trim();
			RichterQualifikation richterQual = richterQualService.findByName(trimmedQual);

			RichterQualAssignment ass = new RichterQualAssignment();
			ass.setRichter(richter);
			ass.setQualifikation(richterQual);

			richter.getQualAssignments().add(ass);
		}

		if (insert) {
			richterService.add(richter);
		} else {
			richterService.update(richter);
		}
	}

}
