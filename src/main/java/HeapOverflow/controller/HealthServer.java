package HeapOverflow.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthServer {

	@RequestMapping("/health")
	public ResponseEntity<String> getStatus() {
		Random randomGenerator = new Random();

		int randomInt = randomGenerator.nextInt(5);
		if (randomInt == 1) {
			return new ResponseEntity<>("Ok", HttpStatus.OK);
		}

		return new ResponseEntity<>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
