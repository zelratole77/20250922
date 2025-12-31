package web.com.springweb.a04_file;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class B02_DownloadController {
	// 1. 초기에 업로드한 경로를 파일다운로드 경로 설정..
	@Value("${user.upload}")
	private String path;
	
	// 2. 파일명으로 get방식으로 전달 처리 및 최종적으로 ResponseEntity를 통해서 전달 처리.
	// http://localhost:5050/download2?fname=img04.jpg
	@GetMapping("download2")
	public ResponseEntity<Resource> downloadFile(@RequestParam("fname") String fname) throws IOException {
		// 3. 전송할 파일 객체 File ==> Path ==> FileSystemResource => Resource ]
		
		Path filePath = Paths.get(path).resolve(fname).normalize();		
		// 4. 현재 파일 시스템의 리소스로 설정해야 파일로 전송이 가능한 객체가 된다.
		Resource resource = new FileSystemResource(filePath);
		// 5. 파일이 존재하지 않을 때는 404 Not Found 응답 처리
		if(!resource.exists()) {
			return ResponseEntity.notFound().build();
		}
		// 6. 전송할 파일명이 한글명일 때, 네트웍상 정상적으로 전송되기 위하여 encoding 처리(네트웍은 1byte로만 전송이 된다)..
		// \\+ 경우에 %20으로 url 요청 공백형식으로 변경
		fname = URLEncoder.encode(resource.getFilename(), StandardCharsets.UTF_8).replaceAll("\\+", "%20");
		// 7. 실제 파일객체를 네트웍상 전송하는 형식을 지정하는데, 설정이 되어 있지 않으면 그냥 8진수 stream으로 설정처리..
		String contentType = Files.probeContentType(filePath);
		//   파일 전송방식이 설정되지 않을 때는 모든 파일을 전송할 수 있는 방식인 application/octet-stream으로 처리..
		if(contentType==null) {
			contentType = "application/octet-stream"; 
		}
		// fileName="파일명.txt"  ==>"  fileName=\"파일명.txt\"  " ==> "  fileName=\""+fname+"\"  " 
		return ResponseEntity.ok()
			   .contentType(MediaType.parseMediaType(contentType))
			   .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\""+fname+"\"  ")
			   .body(resource);
	}
	
	

}
