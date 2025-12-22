package web.com.springweb.a02_mvc.a01_idol;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface A03_Idol_Dao {
	
	@Select("SELECT * FROM TBL_GROUP \r\n"
			+ "	WHERE GROUP_NAME LIKE #{groupName} \r\n"
			+ "	AND FANDOM_NAME LIKE #{fandomName}")
	List<A04Group> getIdolGrpList(A04Group sch);
	

	@Insert("INSERT INTO TBL_GROUP (GROUP_NO, GROUP_NAME, DEBUT_DATE, FANDOM_NAME) \r\n"
			+ "	VALUES (idolgrp_seq.nextval, #{groupName}, #{debutDate}, #{fandomName}) ")
	int insertIdoGrp(A04Group ins);
	
	@Select("SELECT * FROM TBL_GROUP WHERE GROUP_NO = #{groupNo}")
	A04Group  getIdolGrop(@Param("groupNo") int groupNo);
	
}
