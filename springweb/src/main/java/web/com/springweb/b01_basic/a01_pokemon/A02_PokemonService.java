package web.com.springweb.b01_basic.a01_pokemon;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A02_PokemonService {
	@Autowired(required=false)
	private A03_PokemonDao dao;
	
	public List<PokemonDex> pokenmonList(PokemonDex sch){
		
		
		//WHERE name LIKE #{name} AND TYPE LIKE #{type}
		//위내용을 WHERE name LIKE '%%' AND TYPE LIKE '%%'
		//      sql로 처리할려면..
		//  null때는 ""으로   그리고, 양옆에 %%로 처리 해주어야 한다.
		if(sch.getName()==null) sch.setName("");
		if(sch.getType()==null) sch.setType("");
		sch.setName("%"+sch.getName()+"%");
		sch.setType("%"+sch.getType()+"%");
		
		
		return dao.pokenmonList(sch);
	}
	public String pokeInsert(PokemonDex ins) {
		return dao.pokeInsert(ins)>0?"등록성공":"등록실패";
		
	}
	public PokemonDex getDetail(int id) {
		return dao.getDetail(id);
	}
}
