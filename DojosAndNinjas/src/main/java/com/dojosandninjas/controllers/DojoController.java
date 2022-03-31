package com.dojosandninjas.controllers;

import com.dojosandninjas.models.Dojo;
import com.dojosandninjas.services.DojoService;
import com.dojosandninjas.services.NinjaService;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DojoController {
	@Autowired
	private DojoService service;
	
	@Autowired
	private NinjaService ninjaService;
	
	@RequestMapping("/")
	public String launch() {
		return "redirect:/dojos/new";
	}

	@RequestMapping("/dojos/new")
	public String newDojo(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "newDojo.jsp";
	}
	
	@PostMapping("/addDojo")
	public String add(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		}
		this.service.create(dojo);
		return "redirect:/ninjas/new";
	}
	
	@RequestMapping("/dojos/{id}")
	public String viewDojo(Model model, @PathVariable("id") Long id) {
		model.addAttribute("dojo", this.service.find(id));
		return "viewDojo.jsp";
	}
	
	
	
	
	
	
	
}