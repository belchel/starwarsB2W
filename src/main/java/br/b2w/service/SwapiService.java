package br.b2w.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.b2w.response.PlanetResponseSwapiService;
import br.b2w.response.ResultSwapiService;
import br.b2w.util.HttpUtils;

@Service
public class SwapiService {
	static final String URL_API = "https://swapi.co/api/";

	static final String ENDPOINT = "planets";

	private RestTemplate restTemplate;

	@Autowired
	public SwapiService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<ResultSwapiService> findPlanets() {
        ResponseEntity<PlanetResponseSwapiService> result = restTemplate.exchange(URI.create(URL_API).resolve(ENDPOINT).toString(),HttpMethod.GET,HttpUtils.getServiceHeader(), PlanetResponseSwapiService.class);
		return result.getBody().getResults();
	}
	
	public Optional<ResultSwapiService> findPlanetByName(String name) {		
        ResponseEntity<PlanetResponseSwapiService> result = restTemplate.exchange(HttpUtils.getServiceUrl(URL_API, ENDPOINT,name),HttpMethod.GET,HttpUtils.getServiceHeader(), PlanetResponseSwapiService.class);
		return result.getBody().getResults().stream().findFirst();
	}
}
