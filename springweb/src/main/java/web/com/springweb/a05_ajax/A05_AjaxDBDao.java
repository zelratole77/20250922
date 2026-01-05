package web.com.springweb.a05_ajax;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import web.com.springweb.z01_dto.Dept;
import web.com.springweb.z01_dto.IdoleGroup;

@Mapper
public interface A05_AjaxDBDao {

	@Select("SELECT * FROM DEPT WHERE DEPTNO = #{deptno}")
	Dept getDept(@Param("deptno") int deptno);
	
	@Select("SELECT COUNT(*) FROM MEMBER WHERE id=#{id}")
	int isValidId(@Param("id") String id);

	@Select("SELECT * FROM kpop_idols WHERE group_id=#{groupId}")
	IdoleGroup idolInfo(@Param("groupId") int groupId);
	
	
}
