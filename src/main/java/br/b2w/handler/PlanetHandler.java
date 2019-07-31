package br.b2w.handler;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.b2w.contract.IPlanetHandler;
import br.b2w.entity.Planet;
import br.b2w.repository.PlanetRepository;

@Service
public class PlanetHandler implements IPlanetHandler {

	private PlanetRepository planetRepository;

	@Autowired
	public PlanetHandler(PlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}

	public Iterable<Planet> findAll() {
		return this.planetRepository.findAll();
	}

	public Planet save(Planet planet) {
		return this.planetRepository.save(planet);
	}

	public Planet getById(UUID id) {
		return this.planetRepository.findOne(id);
	}
	
	public Planet getByName(String name) {
		return this.planetRepository.findByName(name) ;
	}
	
	public void deleteById(UUID id) {
		this.planetRepository.delete(id) ;
	}
}
