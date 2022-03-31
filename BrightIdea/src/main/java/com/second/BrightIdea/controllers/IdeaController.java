package com.second.BrightIdea.controllers;
 

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

import com.second.BrightIdea.models.Idea;
import com.second.BrightIdea.models.User; 
import com.second.BrightIdea.services.IdeaService;
import com.second.BrightIdea.services.UserService;

@Controller
public class IdeaController {
	
//	@Autowired
//	private IdeaRepository ideaRepo;
	
	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private UserService userService;
	
	//1
	@GetMapping("/brightIdea")
	public String dashboard(Model model, HttpSession session) {
		
		Long userId =(Long) session.getAttribute("userId");
 		//User user = this.userService.findCurrentUser(session);
		if (userId == null) {  
			return "redirect:/";
		} 
		else {
			User currentUser = this.userService.findById(userId);
// 			List<Idea> joinIdea = ideaService.allIdeas();
// 			model.addAttribute("myIdeas",joinIdea);
			model.addAttribute("user", currentUser);
			return "dashboard.jsp";
		}
		
	}
	
	 //2
    @GetMapping("/ideas/{ideaId}")
	public String showIdea (Model model,
							@PathVariable("ideaId") Long ideaId,
							@ModelAttribute("commentIdea") Idea theIdea,
							HttpSession session){
		Idea idea = ideaService.findIdea(ideaId);
		model.addAttribute("idea", idea);
		model.addAttribute("user", session.getAttribute("userId"));
		return "createIdea.jsp";
		
		
	}
	 
    
	@GetMapping("/ideas/new")
	public String newIdea(@ModelAttribute("newIdea") Idea myIdea,
			Model model,
			HttpSession session) {
		 Long id =(Long) session.getAttribute("userId");
		model.addAttribute("userId",id);
		return "createIdea.jsp";
	}

	
	//2
	@PostMapping("/ideas/saveidea")
	public String add(@Valid @ModelAttribute("newIdea") Idea myIdea, 
			BindingResult result ) {
		
		if (result.hasErrors()) {
			return "createIdea.jsp";
		} else {
			
			ideaService.createIdea(myIdea);
			return "redirect:/ideas/new";
		} 
	}
	
	
	
}

