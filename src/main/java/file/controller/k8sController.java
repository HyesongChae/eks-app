package file.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class k8sController {
	
	@GetMapping(value = "/api/status")
	public String GetStatus () {
		return "Status - returned by Pod" ;
	}
	
	@GetMapping(value = "/api/status2")
	public String GetStatus2 () {
		return "Status - returned by Pod2" ;
	}
	
	@GetMapping(value = "/api/status3")
	public String GetStatus3 () {
		return "Status - returned by Pod3" ;
	}
}
