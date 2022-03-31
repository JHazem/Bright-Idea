package com.brayden.brightIdea.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.brayden.brightIdea.models.Idea;
import com.brayden.brightIdea.models.User;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long>{
	List<Idea> findAll();
	Optional<Idea> findById(Long id);
}
