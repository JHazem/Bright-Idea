package com.brayden.brightIdea.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.brayden.brightIdea.models.Idea;
import com.brayden.brightIdea.models.User;
import com.brayden.brightIdea.repositories.UserRepository;
import com.brayden.brightIdea.repositories.IdeaRepository;
import com.brayden.brightIdea.services.UserService;
import com.brayden.brightIdea.services.IdeaService;

@Controller
public class IdeaController {
	
	@Autowired
	private IdeaRepository repository;
	
	@Autowired
	private IdeaService service;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		User user = this.userService.findCurrentUser(session);
		if (user == null)
			return "redirect:/";
		
		model.addAttribute("allIdeas", this.repository.findAll());
		return "dashboard.jsp";
	}
	
	@RequestMapping("/ideas/new")
	public String newBook(Model model, HttpSession session) {
		User user = this.userService.findCurrentUser(session);
		if (user == null)
			return "redirect:/";
		
		model.addAttribute("currentUser", user);
		model.addAttribute("newIdea", new Idea());
		return "createIdea.jsp";
	}
	
	@PostMapping("/add")
	public String add(@Valid @ModelAttribute("newIdea") Idea idea, BindingResult result) {
		if (result.hasErrors()) {
			return "createIdea.jsp";
		}
		this.service.create(idea.getUser().getId(), idea);
		return "redirect:/dashboard";
	}
	
}
