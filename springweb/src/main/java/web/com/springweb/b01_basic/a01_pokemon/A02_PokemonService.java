package web.com.springweb.b01_basic.a01_pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A02_PokemonService {
	@Autowired(required=false)
	private A03_PokemonDao dao;
	

}
