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
		String line = "100050Fuchs                                             Trinity Petra            05LVLR OG Reitclub Alpe Adria                       AUTR1S2      519700030664 4082261          2009W1964081910025560                       ";
		
		// TODO - erzeuge eine line mit allen informationen und teste dann
		Reiter reiter = importReiter.parseIntoPrototype(line);
		assertEquals("100050", reiter.getSatzNrReiter());
		assertEquals("Fuchs", reiter.getFamilienname());
		assertEquals("Trinity Petra", reiter.getVorname());
		
	}
	
}
