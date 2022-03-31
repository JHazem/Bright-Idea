package com.dojosandninjas.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojosandninjas.models.Dojo;
import com.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository repository;
	
	public DojoService (DojoRepository repository) {
		this.repository = repository;
	} 
	
	public Dojo create(Dojo d) {
		return this.repository.save(d);
	}
	
	public List<Dojo> all(){
		return this.repository.findAll();
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	public Dojo save(Dojo d) {
		return this.repository.save(d);
	}
	
	public Dojo find(Long id) {
		Optional<Dojo> optDojo = this.repository.findById(id);
		
		if (optDojo.isPresent()) {
			return optDojo.get();
		}
		else
			return null;
	}
}
