package HeapOverflow.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HealthService {

	private RestTemplate restTemplate = new RestTemplate();

	@Retryable(maxAttempts = 4, value = RuntimeException.class, backoff = @Backoff(delay = 300))
	public String getHealth() {

		return restTemplate.getForObject("http://localhost:8088/health", String.class);
	}

	@Recover
	public String recover() {
		return "Service down";
	}
}
