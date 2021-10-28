package com.stefanmocoat.showoffice.rest;

import com.stefanmocoat.showoffice.jpa.entities.zns.pferd.Pferd;
import com.stefanmocoat.showoffice.service.PferdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/pferd")
public class PferdRestController {

    @Autowired
    PferdService pferdService;

    @GetMapping(path = "/{kopfnummer}")
    public Pferd getByKopfnummer(
            @PathVariable
                    String kopfnummer
    ) {
        return pferdService.findByKopfnummer(kopfnummer);
    }


}
