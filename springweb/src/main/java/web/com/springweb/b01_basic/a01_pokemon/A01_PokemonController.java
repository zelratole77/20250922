package web.com.springweb.b01_basic.a01_pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A01_PokemonController {

	@Autowired(required=false)
	private A02_PokemonService service;
	
	// http://localhost:5050/pokemonList
	@RequestMapping("pokemonList")
	public String pokemonList(PokemonDex sch, Model d) {
		/*
		이름:[    ]  타입:[    ]
			name="name"  name="type"
			
			pokeList
			
			id name type pokeLevel capuredAt
			
			
			
			
		<c:forEach var="pk" items="${pokeList}"
			<tr><td></td><td></td><td></td>
		 * */
		d.addAttribute("pokeList", service.pokenmonList(sch));
		
		return "b01_basic\\a01_pokemon\\a01_pokemonList";
	}
	// 초기화면과 등록처리 controller 같이 처리
	// http://localhost:5050/pokemonInsert
	@RequestMapping("pokemonInsert")
	public String pokemonInsert(PokemonDex ins, Model d) {
		if(ins.getName()!=null) { // 초기화면과 구분..
			d.addAttribute("msg", service.pokeInsert(ins));
		}
		return "b01_basic\\a01_pokemon\\a02_pokemonInsert";
	}
	// http://localhost:5050/pokemonDetail
	@RequestMapping("pokemonDetail")
	public String pokemonDetail() {
		return "b01_basic\\a01_pokemon\\a03_pokemonDetail";
	}	
	
	// b01_basic\a01_pokemon\a01_pokemonList
}
