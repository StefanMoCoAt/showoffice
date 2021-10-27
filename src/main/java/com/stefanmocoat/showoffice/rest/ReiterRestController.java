package com.stefanmocoat.showoffice.rest;

import com.stefanmocoat.showoffice.jpa.entities.zns.Reiter;
import com.stefanmocoat.showoffice.service.ReiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/reiter")
public class ReiterRestController {

    @Autowired
    ReiterService reiterService;

    @GetMapping(path = "/{reitername}")
    public Reiter getByReitername(
            @PathVariable
            String reitername
    ) {
        return reiterService.findByFamilienname(reitername);
    }

}
