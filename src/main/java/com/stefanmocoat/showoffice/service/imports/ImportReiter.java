package com.stefanmocoat.showoffice.service.imports;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanmocoat.showoffice.jpa.entities.AltersKlasse;
import com.stefanmocoat.showoffice.jpa.entities.Bundesland;
import com.stefanmocoat.showoffice.jpa.entities.Lizenz;
import com.stefanmocoat.showoffice.jpa.entities.Reiter;
import com.stefanmocoat.showoffice.jpa.entities.ReiterGeschlecht;
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
		try (BufferedReader reader = new BufferedReader(new FileReader("zns_daten/LIZENZ01_TEST.dat"))) {
			// ,
			// Charset.forName("Cp850");
			String line = reader.readLine();
			while (line != null) {
				Reiter prototype = parseIntoPrototype(line);
				if (prototype != null) {
					addOrUpdateReiter(prototype);
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	Reiter parseIntoPrototype(String line) {
		if (line.length() < 202) {
			return null;
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

		Reiter prototype = new Reiter();
		Verein verein = vereinService.findByVereinId(mitgliedsNr.substring(0, 4));

		prototype.setSatzNrReiter(satzNrReiter);
		prototype.setFamilienname(familienname);
		prototype.setVorname(vorname);
		prototype.setBudesland(Bundesland.findByCode(budesland));
		prototype.setVereinsname(vereinsname);
		prototype.setNationalitaet(nationalitaet);
		prototype.setLizenz(Lizenz.findByCode(lizenz));
		prototype.setStartkarte(startkarte);
		prototype.setFahrlizenz(Lizenz.findByCode(fahrlizenz));
		prototype.setAltersKlJgJrU25(AltersKlasse.findByCode(altersKlJgJrU25));
		prototype.setAltersKlY(AltersKlasse.findByCode(altersKlY));
		prototype.setMitgliedsnummer(mitgliedsNr);
		prototype.setVerein(verein);
		prototype.setTelefonnummer(telNr);
		prototype.setKader(kader);
		prototype.setLetzteZahlungJahr(letzteZahlungJahr);
		prototype.setGeschlecht(ReiterGeschlecht.findByCode(geschlecht));

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		try {
			prototype.setGeburtsdatum(formatter.parse(gebDatum));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		prototype.setFeiId(feiId);
		prototype.setSperrliste(sperrliste);
		prototype.setLizenzinfo(lizenzinfo);

		return prototype;
	}

	private void addOrUpdateReiter(Reiter prototype) {

		Reiter reiter = reiterService.findBySatzNrReiter(prototype.getSatzNrReiter());

		boolean insert = false;
		if (reiter == null) {
			insert = true;
			// in case of insert, we can insert the prototype directly
			// nothing to do here
		} else {
			// in case of update, we need to transfer the new values from prototype to
			// persistent reiter
			reiter.setSatzNrReiter(prototype.getSatzNrReiter());

			reiter.setFamilienname(prototype.getFamilienname());
			reiter.setVorname(prototype.getVorname());
			reiter.setBudesland(prototype.getBudesland());
			reiter.setVereinsname(prototype.getVereinsname());
			reiter.setNationalitaet(prototype.getNationalitaet());
			reiter.setLizenz(prototype.getLizenz());
			reiter.setStartkarte(prototype.getStartkarte());
			reiter.setFahrlizenz(prototype.getFahrlizenz());
			reiter.setAltersKlJgJrU25(prototype.getAltersKlJgJrU25());
			reiter.setAltersKlY(prototype.getAltersKlY());
			reiter.setMitgliedsnummer(prototype.getMitgliedsnummer());
			reiter.setTelefonnummer(prototype.getTelefonnummer());
			reiter.setKader(prototype.getKader());
			reiter.setLetzteZahlungJahr(prototype.getLetzteZahlungJahr());
			reiter.setGeschlecht(prototype.getGeschlecht());
			reiter.setFeiId(prototype.getFeiId());
			reiter.setSperrliste(prototype.getSperrliste());
			reiter.setLizenzinfo(prototype.getLizenzinfo());

		}

		if (insert) {
			reiterService.add(prototype);
		} else {
			reiterService.update(reiter);
		}

	}

}
