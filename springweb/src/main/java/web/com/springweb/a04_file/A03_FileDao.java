package web.com.springweb.a04_file;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface A03_FileDao {

	@Insert("INSERT INTO file_info values(file_seq.nextval, #{fname}, "
			+ "#{fpath},sysdate, sysdate,#{etc})")
	int insertFileInfo(FileInfo ins);
	
	@Select("SELECT * FROM file_info WHERE fname LIKE #{fname}")
	List<FileInfo> getFileList(@Param("fname") String fname);
		

}
