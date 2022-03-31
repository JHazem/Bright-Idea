package com.second.BrightIdea.services;
 

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.BrightIdea.models.Idea;
import com.second.BrightIdea.models.User;
import com.second.BrightIdea.repositories.IdeaRepository; 

@Service
public class IdeaService {
	
	@Autowired
	private IdeaRepository ideaRepo;
	
//	@Autowired
//	private UserService userService;
//	
	
	public List<Idea> allIdeas(){
		return ideaRepo.findAll();
	}
	
	public IdeaService(IdeaRepository ideaRepo) {
		this.ideaRepo = ideaRepo;
	}
	
 
	public Idea findById(Long id) {
		
		return ideaRepo.findById(id).orElse(null);
	}


	public Idea findIdea(Long userID) {
		Optional<Idea> optionalIdea = ideaRepo.findById(userID);
		if(optionalIdea.isPresent()) {
			return optionalIdea.get();
		}
		else {
			return null;
		}
	}
	
	
	
	public Idea createIdea(Idea i) {
		
		return ideaRepo.save(i);
	}

 
	public Idea saveIdea(@Valid Idea myIdea) {
		return  ideaRepo.save(myIdea);
	}
		
 
	public void addUser(Idea idea, User c) {
		c.getUserIdea().add(idea);
		ideaRepo.save(idea);
	}
	
	 
	public void delete(Long id) {
		this.ideaRepo.deleteById(id);
		
	}
	
	
	
}