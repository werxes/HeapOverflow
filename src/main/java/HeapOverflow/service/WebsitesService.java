package HeapOverflow.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import HeapOverflow.domains.Website;
import HeapOverflow.domains.WebsiteDto;

@Service
public class WebsitesService {

	// @Autowired
	// private WebsiteRepository websiteRepository;

	@Autowired
	private HeapOverflowClient heapOverflowClient;

	/*
	 * public List<Website> getAllWebsites() { return websiteRepository.findAll();
	 * 
	 * }
	 */
	// @Cacheable(value= "websites")

	@Async
	public CompletableFuture<List<Website>> getAllWebsitesAsync() throws Exception {
		return CompletableFuture.completedFuture(
				heapOverflowClient.getSites().stream().map(this::toWebsite).collect(Collectors.toList()));
	}

	public List<Website> getAllWebsites() throws Exception {
		return heapOverflowClient.getSites().stream().map(this::toWebsite).collect(Collectors.toList());
	}

	private Website toWebsite(WebsiteDto input) {
		return new Website(Long.valueOf(1), input.getName(), input.getSite_url());
	}

}
