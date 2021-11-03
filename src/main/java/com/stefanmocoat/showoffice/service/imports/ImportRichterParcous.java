package com.stefanmocoat.showoffice.service.imports;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanmocoat.showoffice.jpa.entities.ParcoursBauer;
import com.stefanmocoat.showoffice.jpa.entities.ParcoursBauerQualAssignment;
import com.stefanmocoat.showoffice.jpa.entities.ParcoursBauerQualifikation;
import com.stefanmocoat.showoffice.jpa.entities.Richter;
import com.stefanmocoat.showoffice.jpa.entities.RichterQualAssignment;
import com.stefanmocoat.showoffice.jpa.entities.RichterQualifikation;
import com.stefanmocoat.showoffice.service.ParcoursBauerQualifikationService;
import com.stefanmocoat.showoffice.service.ParcoursBauerService;
import com.stefanmocoat.showoffice.service.RichterQualifikationService;
import com.stefanmocoat.showoffice.service.RichterService;

@Component
public class ImportRichterParcous implements IImport {

	@Autowired
	RichterService richterService;
	
	@Autowired
	ParcoursBauerService parcoursBauerService;
	
	@Autowired
	RichterQualifikationService richterQualService;
	
	@Autowired
	ParcoursBauerQualifikationService parcoursBauerQualService;

	public ImportRichterParcous() {
	}

	public void doImport() {
		try (BufferedReader reader = new BufferedReader(new FileReader("zns_daten/RICHTER01_TEST.dat"))) { // ,
																											// Charset.forName("Cp850")
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
					addParcoursBauerQualsIfNotExists(quals);
					addParcourBauer(znsId, name, quals);
				}

				line = reader.readLine();
			}
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}

	}

	private void addParcourBauer(String parcourId, String name, String[] quals) {
		ParcoursBauer parcoursBauer = parcoursBauerService.findByParcoursBauerId(parcourId);

		boolean insert = false;
		if (parcoursBauer == null) {
			insert = true;
			parcoursBauer = new ParcoursBauer();
			parcoursBauer.setParcousBauerId(parcourId);
		}

		parcoursBauer.setName(name);

		parcoursBauer.getQualAssignments().clear();
		for (String qual : quals) {
			String trimmedQual = qual.trim();
			ParcoursBauerQualifikation parcousQual = parcoursBauerQualService.findByName(trimmedQual);

			ParcoursBauerQualAssignment pbss = new ParcoursBauerQualAssignment();
			pbss.setParcoursBauer(parcoursBauer);
			pbss.setQualifikation(parcousQual);

			parcoursBauer.getQualAssignments().add(pbss);
		}

		if (insert) {
			parcoursBauerService.add(parcoursBauer);
		} else {
			parcoursBauerService.update(parcoursBauer);
		}
	}

	private void addRichter(String richterId, String name, String[] quals) {

		// QUERY to find all richter + quals
//		SELECT R.NAME, RQ.name FROM RICHTER AS R
//		JOIN RICHTER_QUAL_ASSIGNMENT AS RQA ON RQA.RICHTER_ID  = R.ID
//		JOIN RICHTER_QUALIFIKATION AS RQ ON RQ.ID = RQA.QUALIFIKATION_ID
//
//		order by R.name

		Richter richter = richterService.findByRichterId(richterId);

		boolean insert = false;
		if (richter == null) {
			insert = true;
			richter = new Richter();
			richter.setRichterId(richterId);
		}

		richter.setName(name);

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

	private void addParcoursBauerQualsIfNotExists(String[] quals) {
		for (String qual : quals) {
			String trimmedQual = qual.trim();
			ParcoursBauerQualifikation parcoursQual = parcoursBauerQualService.findByName(trimmedQual);
			if (parcoursQual == null) {
				parcoursQual = new ParcoursBauerQualifikation();
				parcoursQual.setName(trimmedQual);
				parcoursBauerQualService.add(parcoursQual);
			}
		}
	}

}
