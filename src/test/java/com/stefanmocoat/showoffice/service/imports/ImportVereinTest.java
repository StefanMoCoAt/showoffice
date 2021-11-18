package com.stefanmocoat.showoffice.service.imports;

import com.stefanmocoat.showoffice.jpa.entities.Verein;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImportVereinTest {

    @Autowired
    ImportVerein importVerein;

    @Test
    void testParseVerein() {
        String line = "1001Österr. Campagnereiter-Gesellschaft";

        Verein verein = importVerein.parseIntoPrototype(line);

        assertEquals("1001", verein.getVereinId());
        assertEquals("Österr. Campagnereiter-Gesellschaft", verein.getVereinName());

    }
}