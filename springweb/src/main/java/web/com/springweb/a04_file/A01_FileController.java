package web.com.springweb.a04_file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class A01_FileController {
	
	// http://localhost:5050/upload
	@GetMapping("upload")
	public String upload() {
		
		return "a07_file\\a01_fileUpload";
	}
	// http://localhost:5050/upload
	@PostMapping("upload")
	public String uploadPost(@RequestParam("report") MultipartFile file) {
		System.out.println("업로드된 파일:"+file.getOriginalFilename());
		
		return "a07_file\\a01_fileUpload";
	}
}
