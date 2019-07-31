package br.b2w.response;

import java.util.UUID;

public class PlanetResponse {
	
	private UUID id;
	
	private String name;

    private String climate;

    private String terrain;
    
    private int appearance;
   
    public PlanetResponse() {}
    
    public PlanetResponse(final UUID id,  final String name, final String climate, final String terrain, int appearance) {
    	this.setId(id);
    	this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.setAppearance(appearance);
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

	public int getAppearance() {
		return appearance;
	}

	public void setAppearance(int appearance) {
		this.appearance = appearance;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
