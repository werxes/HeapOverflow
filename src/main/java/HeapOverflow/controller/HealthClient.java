package HeapOverflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HeapOverflow.service.HealthService;

@RestController
public class HealthClient {

	@Autowired
	public HealthService healthService;

	@RequestMapping("/check")
	public String checkStatus() {

		return healthService.getHealth();

	}

}
