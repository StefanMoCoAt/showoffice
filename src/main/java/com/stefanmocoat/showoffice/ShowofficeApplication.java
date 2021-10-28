package com.stefanmocoat.showoffice;

import com.stefanmocoat.showoffice.jpa.entities.zns.pferd.Pferd;
import com.stefanmocoat.showoffice.jpa.entities.zns.reiter.ImportReiter;
import com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer.ImportRichterParcous;
import com.stefanmocoat.showoffice.jpa.entities.zns.verein.Verein;
import com.stefanmocoat.showoffice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class ShowofficeApplication implements CommandLineRunner {

    static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

 /*   @Autowired
    TurnierService tournierService;*/

    @Autowired
    RichterService richterService;

    @Autowired
    RichterQualifikationService richterQualService;

    @Autowired
    ParcoursBauerService parcoursBauerService;

    @Autowired
    ParcoursBauerQualifikationService parcoursBauerQualService;

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

        new ImportRichterParcous(richterService, parcoursBauerService,
                richterQualService, parcoursBauerQualService).importRichterAndParcourBauer();

        importVerein();

        importPferd();

        new ImportReiter(reiterService).importReiter();

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

}
