package web.com.springweb.a06_ajax_mvc.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import web.com.springweb.a06_ajax_mvc.dto.LunchMenu;

@Mapper
public interface A02_LunchMenuDao {

	@Select("SELECT menu_id, category, menu_name, price_tag FROM LUNCH_MENU\r\n"
			+ "	WHERE menu_name LIKE #{menuName} AND category LIKE #{category}\r\n "
			+ " ORDER BY MENU_ID DESC ")
	List<LunchMenu> lunchMenuList(LunchMenu sch);

	@Insert("INSERT INTO LUNCH_MENU \r\n"
			+ "	VALUES (LUNCH_SEQ.NEXTVAL, #{category}, #{menuName}, #{priceTag}, #{commentMsg})")
	int insertLunchMenu(LunchMenu ins);
	
	@Select("SELECT * FROM LUNCH_MENU WHERE MENU_ID=#{menuId}")
	LunchMenu getLunchMenu(@Param("menuId") int menuId);
	
	
}
