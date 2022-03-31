package com.dojosandninjas.controllers;

import com.dojosandninjas.models.Dojo;
import com.dojosandninjas.models.Ninja;
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
public class NinjaController {
	
	@Autowired
	private NinjaService service;
	
	@Autowired
	private DojoService dojoService;
	
	@RequestMapping("/ninjas/new")
	public String newNinja(Model model) {
		model.addAttribute("ninja", new Ninja());
		model.addAttribute("dojo", this.dojoService.all());
		return "newNinja.jsp";
	}
	
	@PostMapping("/addNinja")
	public String add(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "newNinja.jsp";
		}
		this.service.create(ninja.getDojo().getId(), ninja);
		return "redirect:/dojos/" + ninja.getDojo().getId();
	}
}



