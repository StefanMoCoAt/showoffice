package com.stefanmocoat.showoffice.service.imports;

import com.stefanmocoat.showoffice.jpa.entities.Verein;
import com.stefanmocoat.showoffice.service.VereinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class ImportVerein implements IImport{

    @Autowired
    VereinService vereinService;

    public ImportVerein() {
    }

    @Override
    public void doImport() {
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



}
