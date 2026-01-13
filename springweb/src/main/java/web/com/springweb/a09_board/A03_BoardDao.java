package web.com.springweb.a09_board;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

// a09_board.A03_BoardDao
@Mapper
public interface A03_BoardDao {

	@Select("SELECT * FROM BOARD "
			+ "WHERE WRITER LIKE #{writer} "
			+ "AND SUBJECT LIKE #{subject} "
			+ "ORDER BY NO DESC ")
	List<Board> boardList(Board sch);
	// refno subject content writer
	//Insert("insert into board values(board_seq.nextval,#{refno},#{subject},#{content},#{writer},0,sysdate, sysdate)")
	@Insert("insert into board values(#{no},#{refno},#{subject},#{content},#{writer},0,sysdate, sysdate)")
	@SelectKey(statement="SELECT BOARD_SEQ.NEXTVAL FROM DUAL",
				keyProperty = "no",  // Board의 no 값 설정
				before=true,  // boardInsert가 실행되기 직전에 nextval을 먼저 조회합니다.
				resultType=int.class)
	int boardInsert(Board ins);

	//Insert("INSERT INTO boardfile values(board_seq.currval, #{fname}, #{etc}, sysdate, sysdate)")
	@Insert("INSERT INTO boardfile values(#{no}, #{fname}, #{etc}, sysdate, sysdate)")
	int boardInsertFile(FileDto ins);
	
	
	
	@Select("SELECT * FROM BOARD WHERE NO = #{no}")
	Board getBoard(@Param("no") int no);


	@Update("UPDATE BOARD SET READCNT = READCNT+1 WHERE NO = #{no}")
	int uptReadCnt(@Param("no")int no);

	@Update("	UPDATE BOARD\r\n"
			+ "		SET SUBJECT = #{subject},\r\n"
			+ "		    CONTENT = #{content},\r\n"
			+ "		    WRITER = #{writer},\r\n"
			+ "		    UPTDTE = SYSDATE\r\n"
			+ "	WHERE NO = #{no}")
	int boardUpdate(Board upt);
	
	@Delete("DELETE FROM BOARD WHERE NO = #{no}")
	int boardDelete(@Param("no") int no);	
}
