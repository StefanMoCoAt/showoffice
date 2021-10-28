package com.stefanmocoat.showoffice.rest;

import com.stefanmocoat.showoffice.jpa.entities.zns.richterPacoursbauer.Richter;
import com.stefanmocoat.showoffice.service.RichterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/richter")
public class RichterRestController {

    @Autowired
    RichterService richterService;

    @GetMapping(path = "/{richterId}")
    public Richter getById(@PathVariable String richterId) {
        return richterService.findByRichterId(richterId);
    }
}
