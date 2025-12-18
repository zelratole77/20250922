package web.com.springweb.a02_mvc.a01_idol;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface A03_Idol_Dao {
	
	@Select("SELECT * FROM TBL_GROUP \r\n"
			+ "	WHERE GROUP_NAME LIKE #{groupName} \r\n"
			+ "	AND FANDOM_NAME LIKE #{fandomName}")
	List<A04Group> getIdolGrpList(A04Group sch);
}
