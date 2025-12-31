package web.com.springweb.a04_file;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A12_FileService {

	@Autowired(required=false)
	private A13_FileDao dao;
	
	public List<FileInfo> getFileList(String fname){
		// 원래 fname에 %%를 붙여서 dao sql에 전달..
		fname = "%"+fname+"%";
		
		return dao.getFileList(fname);
	}
}
