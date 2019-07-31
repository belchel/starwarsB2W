package br.b2w.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.b2w.contract.IPlanetHandler;
import br.b2w.entity.Planet;
import br.b2w.request.PlanetRequest;

@RestController
public class PlanetController {

	private IPlanetHandler planetHandler;
	
    @Autowired
    public PlanetController(IPlanetHandler planetHandler) {
        this.planetHandler =planetHandler;
    }
    
    @RequestMapping("/planet/all")
    public Iterable<Planet> getAll() {
        return  planetHandler.findAll();
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
 
    
}
