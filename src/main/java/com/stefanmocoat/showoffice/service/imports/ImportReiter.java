package com.stefanmocoat.showoffice.service.imports;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.stefanmocoat.showoffice.jpa.entities.Bundesland;
import com.stefanmocoat.showoffice.jpa.entities.Lizenz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanmocoat.showoffice.jpa.entities.Reiter;
import com.stefanmocoat.showoffice.jpa.entities.Verein;
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
				String satzNrReiter = line.substring(0, 6); // 6
				String familienname = line.substring(6, 56).trim(); // 50
				String vorname = line.substring(56, 81).trim(); // 25
				String budesland = line.substring(81, 83); // 2
				String vereinsname = line.substring(83, 133).trim(); // 50
				String nationalitaet = line.substring(133, 136); // 3
				String lizenz = line.substring(136, 140).trim(); // 4
				String startkarte = line.substring(140, 141).trim(); // 1
				String fahrlizenz = line.substring(141, 143).trim(); // 2
				String altersKlJgJrU25 = line.substring(143, 145).trim(); // 2
				String altersKlY = line.substring(145, 146).trim(); // 1
				String mitgliedsNr = line.substring(146, 154); // 8
				String telNr = line.substring(154, 175).trim(); // 21
				String kader = line.substring(175, 176).trim(); // 1
				String letzteZahlungJahr = line.substring(176, 180); // 4
				String geschlecht = line.substring(180, 181); // 1
				String gebDatum = line.substring(181, 189); // 8
				String feiId = line.substring(189, 199); // 10
				String sperrliste = line.substring(199, 200); // 1
				String lizenzinfo = line.substring(200).trim(); // 10

				addReiter(satzNrReiter, familienname, vorname, budesland, vereinsname,
						nationalitaet, lizenz, startkarte, fahrlizenz, altersKlJgJrU25,
						altersKlY, mitgliedsNr, telNr, kader,
						letzteZahlungJahr, geschlecht, gebDatum, feiId, sperrliste,
						lizenzinfo);
				line = reader.readLine();
			}
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	private void addReiter(String satzNrReiter, String familienname, String vorname,
			String budesland, String vereinsname, String nationalitaet, String lizenz,
			String startkarte, String fahrlizenz, String altersKlJgJrU25, String altersKlY,
			String mitgliedsNr, String telNr, String kader,
			String letzteZahlungJahr, String geschlecht, String gebDatum, String feiId,
			String sperrliste, String lizenzinfo) {

		Reiter reiter = reiterService.findBySatzNrReiter(satzNrReiter);

		boolean insert = false;
		if (reiter == null) {
			insert = true;
			reiter = new Reiter();
			reiter.setSatzNrReiter(satzNrReiter);
		}

		Verein verein = vereinService.findByVereinId(mitgliedsNr.substring(0, 4));

		reiter.setFamilienname(familienname);
		reiter.setVorname(vorname);

		reiter.setBudesland(Bundesland.findByCode(budesland));

		reiter.setVereinsname(vereinsname);
		reiter.setNationalitaet(nationalitaet);

		reiter.setLizenz(Lizenz.findByCode(lizenz));

		reiter.setStartkarte(startkarte);
		reiter.setFahrlizenz(fahrlizenz);
		reiter.setAltersKlJgJrU25(altersKlJgJrU25);
		reiter.setAltersKlY(altersKlY);
		reiter.setMitgliedsnummer(mitgliedsNr);
		reiter.setVerein(verein);
		reiter.setTelefonnummer(telNr);
		reiter.setKader(kader);
		reiter.setLetzteZahlungJahr(letzteZahlungJahr);
		reiter.setGeschlecht(geschlecht);
		reiter.setGeburtsdatum(gebDatum);
		reiter.setFeiId(feiId);
		reiter.setSperrliste(sperrliste);
		reiter.setLizenzinfo(lizenzinfo);
		if (insert) {
			reiterService.add(reiter);
		} else {
			reiterService.update(reiter);
		}

	}

}
