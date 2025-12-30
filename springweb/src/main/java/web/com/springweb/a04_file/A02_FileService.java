package web.com.springweb.a04_file;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class A02_FileService {
	
	@Autowired(required=false)
	private A03_FileDao dao;
	
	
	// 파일 경로(공통)
	@Value("${user.upload}")
	private String path; // 해당 파일 경로 위치 path에 할당
	
	public String fileUpload(MultipartFile mpf) {
		String msg = "업로드 성공";
		
		// 1. 파일(물리적) 경로, 파일 ==> 물리적 특정 위체에 저장 객체 생성..
		File file = new File(path, mpf.getOriginalFilename());
		
		// 2. 메모리 파일 객체 ==> 물리적 저장 파일로 처리..
		try {
			mpf.transferTo(file);
			dao.insertFileInfo(new FileInfo(mpf.getOriginalFilename(),path,".."));
			
			
		} catch (IllegalStateException e) {
			msg = "[예외 발생1]:상태문제 - "+e.getMessage();
			System.out.println(e.getMessage());
		} catch (IOException e) {
			msg = "[예외 발생2]:파일문제 - "+e.getMessage();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			msg = "[예외 발생3]:기타문제 - "+e.getMessage();
			System.out.println(e.getMessage());
		}
		return msg;
	}

}
