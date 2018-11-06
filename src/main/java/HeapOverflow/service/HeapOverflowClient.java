package HeapOverflow.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import HeapOverflow.domains.WebsiteDto;
import HeapOverflow.domains.WebsitesDto;

@Component
public class HeapOverflowClient {

	HttpClient httpClient = HttpClientBuilder.create().build();

	ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

	private RestTemplate restTemplate = new RestTemplate(requestFactory);


	public List<WebsiteDto> getSites() {

		//simulateSlowService();
		String url = "https://api.stackexchange.com/2.2/sites?page=1&pagesize=9&filter=!6Oe4s7MhKAVie";
		WebsitesDto responce = null;
		try {

			responce = restTemplate.getForObject(new URI(url), WebsitesDto.class);
		} catch (RestClientException | URISyntaxException e) {
			throw new RuntimeException();
		}
		return responce.getItems();
	}

    private void simulateSlowService() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }



}
