package com.brayden.brightIdea.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.brayden.brightIdea.models.Idea;
import com.brayden.brightIdea.models.User;
import com.brayden.brightIdea.repositories.IdeaRepository;
import com.brayden.brightIdea.services.IdeaService;
import com.brayden.brightIdea.services.UserService;

@Controller
public class LikesController {
	@Autowired
	private IdeaRepository repository;
	
	@Autowired
	private IdeaService service;
	
	@Autowired
	private UserService userService;
	
    //rfs  
    @GetMapping("/bright_ideas/{id}")
    public String likeStatus(@PathVariable Long id, HttpSession session, Model model) {
		User user = this.userService.findCurrentUser(session);
		if (user == null)
			return "redirect:/";     
    	
		Idea idea = service.find(id);
		
		model.addAttribute("currentUser", user);
		model.addAttribute("ideas", idea);		 
    	model.addAttribute("allLikedUsers",service.getLikes(idea));
    	    	    	
    	return "likedIdea.jsp";
    }	
    
    @GetMapping("/user/{id}")
    public String userProfile(@PathVariable Long id, HttpSession session, Model model) {
		User user = this.userService.findCurrentUser(session);
		if (user == null)
			return "redirect:/";     
    	
		model.addAttribute("user", userService.find(id));		
	   	    	    	
    	return "displayUser.jsp";
    }	
}
