package web.com.springweb.b01_basic.a01_pokemon;

import java.util.Date;

public class PokemonDex {
	// id name type pokeLevel capuredAt
	private int id;
	private String name;
	private String type;
	private String pokeLevel; // poke_level
	private Date capturedAt; // capured_at   capturedAt
	public PokemonDex() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPokeLevel() {
		return pokeLevel;
	}
	public void setPokeLevel(String pokeLevel) {
		this.pokeLevel = pokeLevel;
	}

	public Date getCapturedAt() {
		return capturedAt;
	}

	public void setCapturedAt(Date capturedAt) {
		this.capturedAt = capturedAt;
	}


	
}
