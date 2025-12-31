package web.com.springweb.a04_file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class A01_FileController {
	@Autowired(required=false)
	private A02_FileService service;
	
	// http://localhost:5050/upload
	@GetMapping("upload")
	public String upload() {
		
		return "a07_file\\a01_fileUpload";
	}
	// http://localhost:5050/upload
	@PostMapping("upload")
	public String uploadPost(@RequestParam("report") MultipartFile file, Model d) {
		System.out.println("업로드된 파일:"+file.getOriginalFilename());
		
		d.addAttribute("msg", service.fileUpload(file));
		
		return "a07_file\\a01_fileUpload";
	}
	// http://192.168.0.39:5050/fileList
	@RequestMapping("fileList")
	public String fileList(@RequestParam(value = "fname", defaultValue = "") String fname, Model d) {
		// fname flist
		d.addAttribute("flist", service.getFileList(fname));
		
		return "a07_file\\a02_fileDownload";
	}	
	
}
