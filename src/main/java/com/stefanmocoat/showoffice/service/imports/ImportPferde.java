package com.stefanmocoat.showoffice.service.imports;

import com.stefanmocoat.showoffice.jpa.entities.*;
import com.stefanmocoat.showoffice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;

@Component
public class ImportPferde implements IImport {

    @Autowired
    PferdService pferdService;

    @Autowired
    PferdeFarbeService pferdeFarbeService;

    @Autowired
    PferdAbstammungService pferdAbstammungService;

    @Autowired
    VereinService vereinService;

    public ImportPferde() {
    }

    public void doImport() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("zns_daten/PFERDE01_TEST.dat")); // ,
            // Charset.forName("Cp850")
            String line = reader.readLine();
            while (line != null) {

                PferdeGeschlecht pferdeGeschlecht;

                String kopfNr = line.substring(0, 4);
                String name = line.substring(4, 34).trim();
                String lebensNr = line.substring(34, 43);

                String inGeschlecht = line.substring(43, 44);
                PferdeGeschlecht geschlecht = PferdeGeschlecht.findByCode(inGeschlecht);

                Year gebJahr = Year.of(Integer.parseInt(line.substring(44, 48)));
                String farbe = line.substring(48, 63).trim();
                String abstammung = line.substring(63, 78).trim();

                String vereinNr = line.substring(78, 82);

                Year letzteZahlungJahr = Year.of(Integer.parseInt(line.substring(82, 86)));

                String verantwortlichePerson = line.substring(86, 161).trim();
                String vater = line.substring(161, 191).trim();
                String feiPass = line.substring(191, 199).trim();
                String satzNr = line.substring(199).trim();

                addPferd(kopfNr, name, lebensNr, geschlecht, gebJahr, farbe,
                        abstammung, vereinNr, letzteZahlungJahr, verantwortlichePerson, vater,
                        feiPass, satzNr);

                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private PferdeFarbe addPferdFarbeIfNotExists(String farbe) {
        String trimmedQual = farbe.trim();
        PferdeFarbe pferdeFarbe = pferdeFarbeService.findByFarbe(farbe);
        if (pferdeFarbe == null) {
            pferdeFarbe = new PferdeFarbe();
            pferdeFarbe.setFarbe(trimmedQual);
            pferdeFarbeService.add(pferdeFarbe);
        }
        return pferdeFarbeService.findByFarbe(farbe);
    }

    private PferdAbstammung addPferdAbstammungIfMotExists(String rasse) {
        String trimmRasse = rasse.trim();
        PferdAbstammung pferdAbstammung = pferdAbstammungService.findByRasse(rasse);
        if (pferdAbstammung == null) {
            pferdAbstammung = new PferdAbstammung();
            pferdAbstammung.setRasse(trimmRasse);
            pferdAbstammungService.add(pferdAbstammung);
        }
        return pferdAbstammungService.findByRasse(rasse);
    }

    private void addPferd(String kopfNr, String name, String lebensNr,
                          PferdeGeschlecht geschlecht, Year gebJahr, String farbe, String abstammung,
                          String vereinNr, Year letzteZahlungJahr, String verantwortlichePerson, String vater,
                          String feiPass, String satzNr) {

        Pferd pferd = pferdService.findByKopfnummer(kopfNr);

        boolean insert = false;
        if (pferd == null) {
            insert = true;
            pferd = new Pferd();
            pferd.setKopfnummer(kopfNr);
        }

        PferdeFarbe pfarbe = addPferdFarbeIfNotExists(farbe);
        PferdAbstammung pAbstammung = addPferdAbstammungIfMotExists(abstammung);

        Verein verein = vereinService.findByVereinId(vereinNr);

        pferd.setPferdename(name);
        pferd.setLebensnummer(lebensNr);
        pferd.setGeschlecht(geschlecht);
        pferd.setGebJahr(gebJahr);
        pferd.setFarbe(pfarbe);
        pferd.setAbstammung(pAbstammung);
        pferd.setVerein(verein);
        pferd.setLetzteZahlungJahr(letzteZahlungJahr);
        pferd.setVerantwortlichePerson(verantwortlichePerson);
        pferd.setVater(vater);
        pferd.setFeiPass(feiPass);
        pferd.setSatznummerDesPferdes(satzNr);

        if (insert) {
            pferdService.add(pferd);
        } else {
            pferdService.update(pferd);
        }
    }

}
