package com.brayden.brightIdea.repositories;

import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.brayden.brightIdea.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findAll();
	Optional<User> findByEmail(String email); //findBy(anykeyword)
}
