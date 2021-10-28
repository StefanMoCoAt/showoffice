package com.stefanmocoat.showoffice.rest;

import com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer.ParcoursBauer;
import com.stefanmocoat.showoffice.service.ParcoursBauerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/parcoursbauer")
public class ParcousrBauerRestController {

    @Autowired
    ParcoursBauerService parcoursBauerService;

    @GetMapping(path = "/{parcousBauerId}")
    public ParcoursBauer getById(@PathVariable String parcousBauerId) {
        return parcoursBauerService.findByParcoursBauerId(parcousBauerId);
    }
}
