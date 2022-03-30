package com.brayden.brightIdea.services;

import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brayden.brightIdea.models.Idea;
import com.brayden.brightIdea.models.User;
import com.brayden.brightIdea.repositories.UserRepository;
import com.brayden.brightIdea.repositories.IdeaRepository;

@Service
public class IdeaService {
	
	@Autowired
	private IdeaRepository repository;
	
	@Autowired
	private UserService userService;
	
	public IdeaService(IdeaRepository repository) {
		this.repository = repository;
	}
	
	public Idea create(Long userID, Idea i) {
		User user = this.userService.find(userID);
		if (user == null)
			return null;
		i.setUser(user);
		return this.repository.save(i);
	}
	
	public Idea save(Idea i) {
		return this.repository.save(i);
	}
	
	public Idea find (Long id) {
		Optional<Idea> optComment = this.repository.findById(id);
		
		if(optComment.isPresent())
			return optComment.get();
		return null;
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
