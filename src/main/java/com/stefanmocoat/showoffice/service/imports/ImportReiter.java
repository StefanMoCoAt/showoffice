package com.stefanmocoat.showoffice.service.imports;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanmocoat.showoffice.jpa.entities.zns.reiter.Reiter;
import com.stefanmocoat.showoffice.jpa.entities.zns.verein.Verein;
import com.stefanmocoat.showoffice.service.ReiterService;
import com.stefanmocoat.showoffice.service.VereinService;

@Component
public class ImportReiter implements IImport {

	@Autowired
	ReiterService reiterService;

	@Autowired
	VereinService vereinService;

	public ImportReiter() {
	}

	public void doImport() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("zns_daten/LIZENZ01_TEST.dat")); // ,
																										// Charset.forName("Cp850")
			String line = reader.readLine();
			while (line != null) {
				if (!(line.length() > 201)) {
					line = reader.readLine();
					continue;
				}
				String reiterSatzNrReiter = line.substring(0, 6); // 6
				String reiterFamilienname = line.substring(6, 56).trim(); // 50
				String reiterVorname = line.substring(56, 81).trim(); // 25
				String reiterBudesland = line.substring(81, 83); // 2
				String reiterVereinsname = line.substring(83, 133).trim(); // 50
				String reiterNationalitaet = line.substring(133, 136); // 3
				String reiterlizenz = line.substring(136, 140).trim(); // 4
				String reiterStartkarte = line.substring(140, 141).trim(); // 1
				String reiterFahrlizenz = line.substring(141, 143).trim(); // 2
				String reiterAltersKlJgJrU25 = line.substring(143, 145).trim(); // 2
				String reiterAltersKlY = line.substring(145, 146).trim(); // 1
				String reiterMitgliedsnummer = line.substring(146, 154); // 8
				String reiterTelefonnummer = line.substring(154, 175).trim(); // 21
				String reiterKader = line.substring(175, 176).trim(); // 1
				String reiterLetzteZahlungJahr = line.substring(176, 180); // 4
				String reiterGeschlecht = line.substring(180, 181); // 1
				String reiterGeburtsdatum = line.substring(181, 189); // 8
				String reiterFeiId = line.substring(189, 199); // 10
				String reiterSperrliste = line.substring(199, 200); // 1
				String reiterLizenzinfo = line.substring(200).trim(); // 10

				addReiter(reiterSatzNrReiter, reiterFamilienname, reiterVorname, reiterBudesland, reiterVereinsname,
						reiterNationalitaet, reiterlizenz, reiterStartkarte, reiterFahrlizenz, reiterAltersKlJgJrU25,
						reiterAltersKlY, reiterMitgliedsnummer, reiterTelefonnummer, reiterKader,
						reiterLetzteZahlungJahr, reiterGeschlecht, reiterGeburtsdatum, reiterFeiId, reiterSperrliste,
						reiterLizenzinfo);
				line = reader.readLine();
			}
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	private void addReiter(String reiterSatzNrReiter, String reiterFamilienname, String reiterVorname,
			String reiterBudesland, String reiterVereinsname, String reiterNationalitaet, String reiterlizenz,
			String reiterStartkarte, String reiterFahrlizenz, String reiterAltersKlJgJrU25, String reiterAltersKlY,
			String reiterMitgliedsnummer, String reiterTelefonnummer, String reiterKader,
			String reiterLetzteZahlungJahr, String reiterGeschlecht, String reiterGeburtsdatum, String reiterFeiId,
			String reiterSperrliste, String reiterLizenzinfo) {

		Reiter reiter = reiterService.findBySatzNrReiter(reiterSatzNrReiter);

		boolean insert = false;
		if (reiter == null) {
			insert = true;
			reiter = new Reiter();
			reiter.setSatzNrReiter(reiterSatzNrReiter);
		}

		Verein verein = vereinService.findByVereinId(reiterMitgliedsnummer.substring(0, 4));

		reiter.setFamilienname(reiterFamilienname);
		reiter.setVorname(reiterVorname);
		reiter.setBudesland(reiterBudesland);
		reiter.setVereinsname(reiterVereinsname);
		reiter.setNationalitaet(reiterNationalitaet);
		reiter.setLizenz(reiterlizenz);
		reiter.setStartkarte(reiterStartkarte);
		reiter.setFahrlizenz(reiterFahrlizenz);
		reiter.setAltersKlJgJrU25(reiterAltersKlJgJrU25);
		reiter.setAltersKlY(reiterAltersKlY);
		reiter.setMitgliedsnummer(reiterMitgliedsnummer);
		reiter.setVerein(verein);
		reiter.setTelefonnummer(reiterTelefonnummer);
		reiter.setKader(reiterKader);
		reiter.setLetzteZahlungJahr(reiterLetzteZahlungJahr);
		reiter.setGeschlecht(reiterGeschlecht);
		reiter.setGeburtsdatum(reiterGeburtsdatum);
		reiter.setFeiId(reiterFeiId);
		reiter.setSperrliste(reiterSperrliste);
		reiter.setLizenzinfo(reiterLizenzinfo);
		if (insert) {
			reiterService.add(reiter);
		} else {
			reiterService.update(reiter);
		}

	}

}
