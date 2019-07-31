package br.b2w.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import br.b2w.contract.IPlanetHandler;
import br.b2w.entity.Planet;
import br.b2w.request.PlanetRequest;
import br.b2w.response.PlanetResponse;
import br.b2w.service.SwapiService;

@RestController
public class PlanetController {

	private IPlanetHandler planetHandler;
	
	private SwapiService service;
	
    @Autowired
    public PlanetController(IPlanetHandler planetHandler,SwapiService service ) {
        this.planetHandler =planetHandler;
        this.service=service;
    }
    
    @GetMapping("/planet")
    public List<PlanetResponse> getAll() {
    	List<PlanetResponse> results = Lists.newArrayList(planetHandler.findAll()).stream()
        .map(s -> new PlanetResponse
        		(s.getId(),
        		s.getName(), 
        		s.getClimate(), 
        		s.getTerrain(), 
        		service.findPlanetByName(s.getName()).map(x-> x.getFilms().size()).orElse(0)))
        .collect(Collectors.toList());
    	
        return  results;
    }
    
    @PostMapping("/planet")
    public ResponseEntity<Planet> savePlanet(@RequestBody PlanetRequest planetRequest) {
    	Planet planet = new Planet(UUID.randomUUID(), planetRequest.getName(),planetRequest.getClimate(),planetRequest.getTerrain());
		return new ResponseEntity<Planet>(planetHandler.save(planet),HttpStatus.CREATED) ;
	}
    
    @GetMapping("/planet/{id}")
    public ResponseEntity<Planet>  getById(@PathVariable UUID id, HttpServletResponse res) {
		return new  ResponseEntity<Planet>(planetHandler.getById(id), planetHandler.getById(id)==null?HttpStatus.NOT_FOUND:HttpStatus.OK);
	}
 
    @GetMapping("/planet/byName")
    public ResponseEntity<Planet>  getByName(@RequestParam String name, HttpServletResponse res) {
		return new  ResponseEntity<Planet>(planetHandler.getByName(name) , planetHandler.getByName(name)==null?HttpStatus.NOT_FOUND:HttpStatus.OK);
	}
    
    @DeleteMapping("/planet/{id}")
    public ResponseEntity<Planet>  deleteById(@RequestParam  UUID id, HttpServletResponse res) {
    	planetHandler.deleteById(id);
    	return new  ResponseEntity<>(HttpStatus.OK);
 	}
}
