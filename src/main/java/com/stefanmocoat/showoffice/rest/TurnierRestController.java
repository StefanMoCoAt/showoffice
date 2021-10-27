/*
package com.stefanmocoat.showoffice.rest;

import com.stefanmocoat.showoffice.jpa.entities.zns.Turnier;
import com.stefanmocoat.showoffice.service.TurnierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/turniere")
public class TurnierRestController {

    @Autowired
    TurnierService tournierService;

    @GetMapping(path = "/{tournierId}")
    public Turnier getById(@PathVariable Integer tournierId) {
        return tournierService.findOne(tournierId);
    }
}
*/
