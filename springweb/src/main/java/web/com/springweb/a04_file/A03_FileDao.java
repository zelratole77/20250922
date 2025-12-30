package web.com.springweb.a04_file;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface A03_FileDao {

	@Insert("INSERT INTO file_info values(file_seq.nextval, #{fname}, "
			+ "#{fpath},sysdate, sysdate,#{etc})")
	int insertFileInfo(FileInfo ins);

}
