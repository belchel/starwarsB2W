package br.b2w.repository;


import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.b2w.entity.Planet;


public interface PlanetRepository extends MongoRepository<Planet, UUID> {
 
	 public Planet findByName(String name);
	 
}
