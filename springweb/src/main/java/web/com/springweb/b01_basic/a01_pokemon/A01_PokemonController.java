package web.com.springweb.b01_basic.a01_pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class A01_PokemonController {

	@Autowired(required=false)
	private A02_PokemonService service;
	
	// http://localhost:5050/pokemonList
	public String pokemonList() {
		return "b01_basic\\a01_pokemon\\a01_pokemonList";
	}
	// http://localhost:5050/pokemonInsert
	public String pokemonInsert() {
		return "b01_basic\\a01_pokemon\\a02_pokemonInsert";
	}
	// http://localhost:5050/pokemonDetail
	public String pokemonDetail() {
		return "b01_basic\\a01_pokemon\\a03_pokemonDetail";
	}	
	
	// b01_basic\a01_pokemon\a01_pokemonList
}
