package web.com.springweb.a04_file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class A11_FileController {
	@Autowired(required=false)
	private A12_FileService service;
	
	// http://localhost:5050/fileList2
	// RequestMapping : get방식과 post 방식 둘다 처리..
	@RequestMapping("fileList2")
	public String fileList2(@RequestParam(value="fname", defaultValue = "") String fname, Model d) {
		
		d.addAttribute("flist", service.getFileList(fname));
		
		return "a07_file\\a03_fileList";
	}
	

}
