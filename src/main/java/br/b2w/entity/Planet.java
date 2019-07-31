package br.b2w.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planets")
public class Planet {
	
	@Id
	private UUID id;

    private String name;

    private String climate;

    private String terrain;
   

    public Planet(final UUID id, final String name, final String climate, final String terrain) {
        this.id = id;
    	this.name = name;
        this.climate = climate;
        this.terrain = terrain;
    }


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getClimate() {
		return climate;
	}


	public void setClimate(String climate) {
		this.climate = climate;
	}


	public String getTerrain() {
		return terrain;
	}


	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

}
