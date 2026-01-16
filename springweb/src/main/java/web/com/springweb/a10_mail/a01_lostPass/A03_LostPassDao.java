package web.com.springweb.a10_mail.a01_lostPass;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface A03_LostPassDao {

	
	
	//  id통하여 발송할 메일 가져온다.
	@Select("SELECT email FROM MEMBER03 WHERE id=#{id}")
	String getEmailById(@Param("id") String id);

	
	// id를 통해서 비밀번호 분실시, 임의의 비밀번호 8자리로 업데이트 한다.
	@Update("	UPDATE MEMBER03\r\n"
			+ "	       SET pwd = #{pwd} \r\n"
			+ "	 WHERE id = #{id}")
	int updateTempPass(Member upt);
	
	// 최종적으로 id pass 로그 가능 여부
	@Select("SELECT * FROM MEMBER03 WHERE ID=#{id} AND PWD=#{pwd}")
	Member login(Member sch);
	
}
