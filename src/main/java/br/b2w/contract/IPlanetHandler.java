package br.b2w.contract;

import java.util.UUID;

import br.b2w.entity.Planet;

public interface IPlanetHandler {
	
	public Iterable<Planet> findAll();   
    
	public Planet save(Planet planet);
	
	public Planet getById(UUID id);

	
}	
