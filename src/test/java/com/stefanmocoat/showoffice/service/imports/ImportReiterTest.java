package com.stefanmocoat.showoffice.service.imports;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stefanmocoat.showoffice.jpa.entities.Reiter;

@SpringBootTest
public class ImportReiterTest {

	@Autowired
	ImportReiter importReiter;

	@Test
    void testParseReiter() {
		String line = "123456Mustermann                                        Maximilian               01MusterReitstall St. Münster                       AUTR1D2SF1JGY12345678123456789012345678901K1999M20200101FEI456789ZSLizenzinfo";
		
		// TODO - erzeuge eine line mit allen informationen und teste dann
		Reiter reiter = importReiter.parseIntoPrototype(line);
		assertEquals("123456", reiter.getSatzNrReiter());
		assertEquals("Mustermann", reiter.getFamilienname());
		assertEquals("Maximilian", reiter.getVorname());
		assertEquals("01", reiter.getBudesland().getLaedercode());
		assertEquals("MusterReitstall St. Münster", reiter.getVereinsname());
		assertEquals("AUT", reiter.getNationalitaet());
		assertEquals("R1D2", reiter.getLizenz().getCode());
		assertEquals("S", reiter.getStartkarte());
		assertEquals("F1", reiter.getFahrlizenz().getCode());
		assertEquals("JG", reiter.getAltersKlJgJrU25().getWerte());
		assertEquals("Y", reiter.getAltersKlY().getWerte());
		assertEquals("12345678", reiter.getMitgliedsnummer());
		assertEquals("123456789012345678901", reiter.getTelefonnummer());
		assertEquals("K", reiter.getKader());
		assertEquals("1999", reiter.getLetzteZahlungJahr());
		assertEquals("M", reiter.getGeschlecht().getCode());
		assertEquals("20200101", reiter.getGeburtsdatum());
		assertEquals("FEI456789Z", reiter.getFeiId());
		assertEquals("S", reiter.getSperrliste());
		assertEquals("Lizenzinfo", reiter.getLizenzinfo());

	}
	
}
