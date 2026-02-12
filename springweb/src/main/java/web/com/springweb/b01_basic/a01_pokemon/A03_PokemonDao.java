package web.com.springweb.b01_basic.a01_pokemon;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface A03_PokemonDao {
	
	@Select("SELECT * FROM pokemon_dex WHERE name LIKE #{name} AND TYPE LIKE #{type}")
	List<PokemonDex> pokenmonList(PokemonDex sch);
	// name, type, pokeLevel
	@Insert("INSERT INTO pokemon_dex (name, type, poke_level)  VALUES (#{name}, #{type}, #{pokeLevel})")
	int pokeInsert(PokemonDex ins);
		
	@Select("SELECT * FROM pokemon_dex WHERE id = #{id}")
	PokemonDex getDetail(@Param("id") int id);
}
