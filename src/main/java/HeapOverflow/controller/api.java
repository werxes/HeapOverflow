package HeapOverflow.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HeapOverflow.domains.Website;
import HeapOverflow.service.WebsitesService;

@RestController
public class api {

	@Autowired
	private WebsitesService websitesService;

	@RequestMapping("/api/heapoverflow")
	public CompletableFuture<List<Website>> getWebSites() throws Exception {
		return websitesService.getAllWebsitesAsync();
	}

}
