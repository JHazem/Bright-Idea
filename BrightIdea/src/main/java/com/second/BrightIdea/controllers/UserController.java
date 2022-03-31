package com.second.BrightIdea.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.second.BrightIdea.models.LoginUser;
import com.second.BrightIdea.models.User;
import com.second.BrightIdea.services.UserService;
import com.second.BrightIdea.validator.UserValidator; 

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/")
	public String welcome(@ModelAttribute("newUser") User user, Model model) {
		
		model.addAttribute("user", new User());
		model.addAttribute("newLogin",new LoginUser() );
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("newUser") User user,
								BindingResult result,
								HttpSession session,
								RedirectAttributes redirectAttributes) {
		
		userValidator.validate(user, result);
		if(result.hasErrors()) {
	 	return "index.jsp";
	 		
	}else {
		
		User newUser = userService.registerUser(user);
 		session.setAttribute("userId", newUser.getId());
 		redirectAttributes.addFlashAttribute("message","Thank you for registration!");
 		return "redirect:/brightIdea";
 	}
}
	
							// Login 
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email,
				@RequestParam("password") String password,
				HttpSession session,
				RedirectAttributes redirectAttributes) {
		
		
		if(userService.authenticateUser(email, password)) {

	    	 User user = userService.findByEmail(email);
	    	 session.setAttribute("userId",user.getId());
	         return "redirect:/home";
	     }
	     else {									//"error" is a key for valid login in index.jsp file		
			 redirectAttributes.addFlashAttribute("error","Invalid user password");
			 return "redirect:/";
		 }	
	}
	
	 
	 // Logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	 
	
	 // Project Dashboard
	 @GetMapping("/home")
	 public String projects(Model model,HttpSession session) {
		 if(session.getAttribute("userId") !=null) {
			 User user = userService.findById((Long) session.getAttribute("userId"));
			 model.addAttribute("user" , user);
			 return "dashboard.jsp";
		 }else {
			 return "redirect:/register";
		 }
	 }


}

