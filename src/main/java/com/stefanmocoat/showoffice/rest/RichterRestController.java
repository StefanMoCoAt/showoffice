package com.stefanmocoat.showoffice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanmocoat.showoffice.jpa.entities.zns.Richter;
import com.stefanmocoat.showoffice.service.RichterService;

@Component
@RestController
@RequestMapping("/richter")
public class RichterRestController {

	@Autowired
	RichterService richterService;

	@GetMapping(path = "/{znsId}")
	public Richter getById(@PathVariable String znsId) {
		return richterService.findByZnsId(znsId);
	}
}
