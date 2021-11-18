package com.stefanmocoat.showoffice.service.imports;

import com.stefanmocoat.showoffice.jpa.entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ImportReiterTest {

	final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	
	@Autowired
	ImportReiter importReiter;

	@Test
	void testParseReiter() {
		String line = "123456Mustermann                                        Maximilian               01MusterReitstall St. Münster                       AUTR1D2SF1JGY12345678123456789012345678901K1999M20200101FEI456789ZSLizenzinfo";

		Reiter reiter = importReiter.parseIntoPrototype(line);

		assertEquals("123456", reiter.getSatzNrReiter());
		assertEquals("Mustermann", reiter.getFamilienname());
		assertEquals("Maximilian", reiter.getVorname());
		assertEquals(Bundesland.WIEN, reiter.getBudesland());
		assertEquals("MusterReitstall St. Münster", reiter.getVereinsname());
		assertEquals("AUT", reiter.getNationalitaet());
		assertEquals(Lizenz.R1D2, reiter.getLizenz());
		assertEquals("S", reiter.getStartkarte());
		assertEquals(Lizenz.F1, reiter.getFahrlizenz());
		assertEquals(AltersKlasse.JUGENDLICH, reiter.getAltersKlJgJrU25());
		assertEquals(AltersKlasse.JUNGERREITER, reiter.getAltersKlY());
		assertEquals("12345678", reiter.getMitgliedsnummer());
		assertEquals("123456789012345678901", reiter.getTelefonnummer());
		assertEquals("K", reiter.getKader());
		assertEquals("1999", reiter.getLetzteZahlungJahr());
		assertEquals(ReiterGeschlecht.MAENLICH, reiter.getGeschlecht());
		assertEquals("20200101", formatter.format(reiter.getGeburtsdatum()));
		assertEquals("FEI456789Z", reiter.getFeiId());
		assertEquals("S", reiter.getSperrliste());
		assertEquals("Lizenzinfo", reiter.getLizenzinfo());

	}

}
