package HeapOverflow.controller;

import java.util.List;

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
	public List<Website> getWebSites() {
		return websitesService.getAllWebsites();
	}

}
