package com.brayden.brightIdea.services;

import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brayden.brightIdea.models.User;
import com.brayden.brightIdea.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public User authenticate(User u) {
		
		Optional<User> foundUser = this.repository.findByEmail(u.getEmail());
		
		if (foundUser.isEmpty() || ! BCrypt.checkpw(u.getPassword(), foundUser.get().getPassword()))
			return null;
		return foundUser.get();
	}
	
	public User find(Long id) {
		return this.repository.findById(id).get();
	}
	
	public User findCurrentUser(HttpSession session) {
		if (session.getAttribute("userID") == null)
			return null;
		return this.find((Long) session.getAttribute("userID"));
	}
	
	public User create(User u) {
		String hashedPassword = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		u.setPassword(hashedPassword);
		return this.repository.save(u);
	}
}
