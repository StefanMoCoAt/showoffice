package com.stefanmocoat.showoffice;

import com.stefanmocoat.showoffice.jpa.entities.zns.*;
import com.stefanmocoat.showoffice.jpa.entities.zns.pferde.Pferd;
import com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer.*;
import com.stefanmocoat.showoffice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class ShowofficeApplication implements CommandLineRunner {

    static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

 /*   @Autowired
    TurnierService tournierService;*/

    @Autowired
    RichterService richterService;

    @Autowired
    ParcourBauerService parcourBauerService;

    @Autowired
    RichterQualifikationService richterQualService;

    @Autowired
    VereinService vereinService;

    @Autowired
    PferdService pferdService;

	@Autowired
	ReiterService reiterService;

    public static void main(String[] args) {
        SpringApplication.run(ShowofficeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // hier importieren wir manuell die Datei Richter.dat
        importRichterAndParcourBauer();

        importVerein();

        importPferd();

        new ImportReiter(reiterService).importReiter();

        // do some tests
        Richter r1 = richterService.findByRichterId("010068");
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



    private void importPferd() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("zns_daten/PFERDE01_TEST.dat")); // , Charset.forName("Cp850")
            String line = reader.readLine();
            while (line != null) {
                String pferdKopfnummer = line.substring(0, 4);
                String pferdPferdename = line.substring(4, 34).trim();
                String pferdLebensnummer = line.substring(34, 43);
                String pferdGeschlecht = line.substring(43, 44);
                String pferdGebJahr = line.substring(44, 48);
                String pferdFarbe = line.substring(48, 63).trim();
                String pferdAbstammung = line.substring(63, 78).trim();
                String pferdVereinNr = line.substring(78, 82);
                String pferdLetzteZahlungJahr = line.substring(82, 86);
                String pferdVerantwortlichePerson = line.substring(86, 161).trim();
                String pferdVater = line.substring(161, 191).trim();
                String pferdFeiPass = line.substring(191, 199).trim();
                String pferdSatznummerDesPferdes = line.substring(199).trim();

                addPferd(pferdKopfnummer, pferdPferdename, pferdLebensnummer, pferdGeschlecht,
                        pferdGebJahr, pferdFarbe, pferdAbstammung, pferdVereinNr, pferdLetzteZahlungJahr, pferdVerantwortlichePerson,
                        pferdVater, pferdFeiPass, pferdSatznummerDesPferdes);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private void addPferd(String pferdKopfnummer, String pferdPferdename, String pferdLebensnummer, String pferdGeschlecht,
                          String pferdGebJahr, String pferdFarbe, String pferdAbstammung, String pferdVereinNr, String pferdLetzteZahlungJahr, String pferdVerantwortlichePerson,
                          String pferdVater, String pferdFeiPass, String pferdSatznummerDesPferdes) {

        Pferd byKopfnummer = pferdService.findByKopfnummer(pferdKopfnummer);

        boolean insert = false;
        if (byKopfnummer == null) {
            insert = true;
            byKopfnummer = new Pferd();
            byKopfnummer.setKopfnummer(pferdKopfnummer);
        }

        byKopfnummer.setPferdename(pferdPferdename);
        byKopfnummer.setLebensnummer(pferdLebensnummer);
        byKopfnummer.setGeschlecht(pferdGeschlecht);
        byKopfnummer.setGebJahr(pferdGebJahr);
        byKopfnummer.setFarbe(pferdFarbe);
        byKopfnummer.setAbstammung(pferdAbstammung);
        byKopfnummer.setVereinNr(pferdVereinNr);
        byKopfnummer.setLetzteZahlungJahr(pferdLetzteZahlungJahr);
        byKopfnummer.setVerantwortlichePerson(pferdVerantwortlichePerson);
        byKopfnummer.setVater(pferdVater);
        byKopfnummer.setFeiPass(pferdFeiPass);
        byKopfnummer.setSatznummerDesPferdes(pferdSatznummerDesPferdes);

        if (insert) {
            pferdService.add(byKopfnummer);
        } else {
            pferdService.update(byKopfnummer);
        }
    }

    private void importVerein() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("zns_daten/VEREIN01_TEST.dat")); // , Charset.forName("Cp850")
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

    private void addVerein(String vereinNr, String vereinName) {

        Verein byVereinNr = vereinService.findByVereinId(vereinNr);

        boolean insert = false;
        if (byVereinNr == null) {
            insert = true;
            byVereinNr = new Verein();
            byVereinNr.setVereinId(vereinNr);
        }

        byVereinNr.setVereinName(vereinName);

        if (insert) {
            vereinService.add(byVereinNr);
        } else {
            vereinService.update(byVereinNr);
        }
    }

    private void importRichterAndParcourBauer() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("zns_daten/RICHTER01_TEST.dat"))) { // , Charset.forName("Cp850")
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

    private void addParcourBauer(String parcourId, String name, String[] quals) {
        ParcoursBauer parcoursBauer = parcourBauerService.findByParcourId(parcourId);

        boolean insert = false;
        if (parcoursBauer == null) {
            insert = true;
            parcoursBauer = new ParcoursBauer();
            parcoursBauer.setZnsId(parcourId);
        }

        parcoursBauer.setName(name);
//		parcourBauer.setQualifikationen(quals);

        if (insert) {
            parcourBauerService.add(parcoursBauer);
        } else {
            parcourBauerService.update(parcoursBauer);
        }
    }

    private void addRichter(String richterId, String name, String[] quals) {

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

        Richter richter = richterService.findByRichterId(richterId);

        boolean insert = false;
        if (richter == null) {
            insert = true;
            richter = new Richter();
            richter.setRichterId(richterId);
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
