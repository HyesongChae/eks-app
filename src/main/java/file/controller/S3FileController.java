package file.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;

import file.service.S3Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
// REST Controller는 API 요청으로 처리하는 Controller (Page X)
@RestController
public class S3FileController {
	
	private final S3Service s3Service;
	private final AmazonS3 amazonS3;
	
	@GetMapping(value = "/api/s3/status")
	public String checkStatus () {
		return "eks-s3-api";
	}
	
	@PostMapping(value = "/api/s3/files")
	public void uploadS3File(@RequestPart(value = "file", required = false) MultipartFile file) {
		try {
			s3Service.uploadS3File(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(value = "/api/s3/files/{fileNo}")
	public ResponseEntity<Resource> downloadS3File(@PathVariable("fileNo") long fileNo) throws Exception {
		return s3Service.downloadS3File(fileNo);
	}
	
	@DeleteMapping(value = "/api/s3/files/{fileNo}")
	public void deleteS3File(@PathVariable("fileNo") long fileNo) {
		
		// 파일 존재 여부(db) - JPA
		
		// 파일 삭제 메서드(s3, db) - S3, JPA
		// amazonS3.deleteObject("버킷 이름", "버킷 내부 경로/파일명");
		amazonS3.deleteObject("s3-bucket-app-chs", "s3_data/f4c4d63f-0db0-411e-82b8-6515ed58d26b_eks-s3-test.txt");
	}
}

