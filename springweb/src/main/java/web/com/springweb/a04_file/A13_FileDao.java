package web.com.springweb.a04_file;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface A13_FileDao {

	
	@Select("SELECT * FROM file_info WHERE fname LIKE #{fname}")
	List<FileInfo> getFileList(@Param("fname") String fname);
	
}
