package web.com.springweb.a09_board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// a09_board.A03_BoardDao
@Mapper
public interface A03_BoardDao {

	@Select("SELECT * FROM BOARD "
			+ "WHERE WRITER LIKE #{writer} "
			+ "AND SUBJECT LIKE #{subject} ")
	List<Board> boardList(Board sch);
}
