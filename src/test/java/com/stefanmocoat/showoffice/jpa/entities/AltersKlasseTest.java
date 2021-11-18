package com.stefanmocoat.showoffice.jpa.entities;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AltersKlasseTest {

	@Test
    void testEnum() {
		assertSame(AltersKlasse.JUGENDLICH, AltersKlasse.findByCode("JG"));
		assertSame(AltersKlasse.JUNGERREITER, AltersKlasse.findByCode("Y"));
		assertSame(AltersKlasse.JUNIOR, AltersKlasse.findByCode("JR"));
		assertSame(AltersKlasse.U25, AltersKlasse.findByCode("25"));
		assertNull(AltersKlasse.findByCode("foo"));
		
		// test internal trim()
		assertSame(AltersKlasse.JUGENDLICH, AltersKlasse.findByCode("   JG "));
		assertSame(AltersKlasse.JUNGERREITER, AltersKlasse.findByCode("   Y   "));
		assertSame(AltersKlasse.JUNIOR, AltersKlasse.findByCode("  JR"));
		assertSame(AltersKlasse.U25, AltersKlasse.findByCode("25   "));
		
		assertEquals(4, AltersKlasse.values().length);
    }
	
}
