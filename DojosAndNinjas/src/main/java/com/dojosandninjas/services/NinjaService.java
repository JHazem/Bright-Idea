package com.dojosandninjas.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojosandninjas.models.Ninja;
import com.dojosandninjas.models.Dojo;
import com.dojosandninjas.repositories.DojoRepository;
import com.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository repository;
	
	@Autowired
	private DojoService dojoService;
	
	public NinjaService (NinjaRepository repository) {
		this.repository = repository;
	} 
	
	public Ninja create(Long dojoId, Ninja n) {
		
		Dojo dojo = this.dojoService.find(dojoId);
		if (dojo == null)
			return null;
		n.setDojo(dojo);
		return this.repository.save(n);
	}
	
	public List<Ninja> all(){
		return this.repository.findAll();
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	public Ninja save(Ninja n) {
		return this.repository.save(n);
	}
	
	public Ninja find(Long id) {
		Optional<Ninja> optNinja = this.repository.findById(id);
		
		if (optNinja.isPresent()) {
			return optNinja.get();
		}
		else
			return null;
	}
}
