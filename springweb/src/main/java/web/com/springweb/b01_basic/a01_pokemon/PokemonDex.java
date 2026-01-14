package web.com.springweb.b01_basic.a01_pokemon;

public class PokemonDex {
	private int id;
	private String name;
	private String type;
	private String pokeLevel; // poke_level
	private String capuredAt; // capured_at
	public PokemonDex() {
		// TODO Auto-generated constructor stub
	}
	public PokemonDex(int id, String name, String type, String pokeLevel, String capuredAt) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.pokeLevel = pokeLevel;
		this.capuredAt = capuredAt;
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
	public String getCapuredAt() {
		return capuredAt;
	}
	public void setCapuredAt(String capuredAt) {
		this.capuredAt = capuredAt;
	}
	
}
