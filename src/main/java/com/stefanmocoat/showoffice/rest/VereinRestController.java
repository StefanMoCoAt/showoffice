package com.stefanmocoat.showoffice.rest;

import com.stefanmocoat.showoffice.jpa.entities.zns.verein.Verein;
import com.stefanmocoat.showoffice.service.VereinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/verein")
public class VereinRestController {

    @Autowired
    VereinService vereinService;

    @GetMapping(path ="/{vereinId}")
    public Verein getById(@PathVariable String vereinId) { return vereinService.findByVereinId(vereinId);}

}
