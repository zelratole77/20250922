package web.com.springweb.a06_ajax_mvc.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import web.com.springweb.a06_ajax_mvc.dto.LunchMenu;

@Mapper
public interface A02_LunchMenuDao {

	@Select("SELECT menu_id, category, menu_name FROM LUNCH_MENU\r\n"
			+ "	WHERE menu_name LIKE #{menuName} AND category LIKE #{category}")
	List<LunchMenu> lunchMenuList(LunchMenu sch);

}
