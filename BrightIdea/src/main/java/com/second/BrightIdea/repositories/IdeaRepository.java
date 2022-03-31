package com.second.BrightIdea.repositories;
 
import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.BrightIdea.models.Idea; 

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long>{
	List<Idea> findAll();
	Optional<Idea> findById(Long id);
}