package com.brayden.brightIdea.controllers;

import javax.servlet.http.HttpSession;
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
import com.brayden.brightIdea.models.User;
import com.brayden.brightIdea.repositories.UserRepository;
import com.brayden.brightIdea.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository repository;
	
	@RequestMapping("/")
	public String welcome(@ModelAttribute("newLogin") User loginUser, @ModelAttribute("newUser") User user,  HttpSession session) {
		
//		user = this.service.findCurrentUser(session);
//		if (user == null)
//			return "redirect:/";
		 
		return "index.jsp";
	}
	
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") User user, BindingResult result,  @ModelAttribute("newUser") User newUser, HttpSession session, Model model) {
		
		user = this.service.authenticate(user);
		if(user != null) {
			session.setAttribute("userID", user.getId());
			session.setAttribute("userName", user.getName());
			return "redirect:/dashboard";
		}
		
		
		model.addAttribute("message", "Invalid Credentials.");
			
		return "index.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User user, BindingResult result, @ModelAttribute("newLogin") User newLogin, HttpSession session) {
		
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The passwords must match!!!");
		}
		
		if(this.repository.findByEmail(user.getEmail()).isPresent()) {
			result.rejectValue("email", "Matches", "The email address is unavailable.");
		}
		
		if(result.hasErrors())
			return "index.jsp";
		
		String loggedUser = (String) session.getAttribute("userName");
		if(loggedUser == null) {
			session.setAttribute("userName", user.getName());		
		}
			
		User newUser = this.service.create(user);
		session.setAttribute("userID", newUser.getId());
		return "redirect:/dashboard";
	}

}
