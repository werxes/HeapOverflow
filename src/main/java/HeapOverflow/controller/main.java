package HeapOverflow.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import HeapOverflow.domains.User;
import HeapOverflow.domains.Website;
import HeapOverflow.service.WebsitesService;

@Controller
public class main {

	@Autowired
	private WebsitesService websitesService;

	@GetMapping("/")
	public String index(@AuthenticationPrincipal User user, Model model) {
		model.addAttribute("username", user.getUsername());
		return "index";
	}

	@GetMapping("/angular")
	public String angular(@AuthenticationPrincipal User user, Model model) {
		model.addAttribute("username", user.getUsername());
		return "angular";
	}

	@GetMapping("/handleerror")
	public String handleerror(Model model) {

		List<Website> websitesOne = new ArrayList<Website>();

		try {
			websitesOne = websitesService.getAllWebsites();
		} catch (Exception e) {
			model.addAttribute("error", e.toString());
		}
		model.addAttribute("websitesOne", websitesOne);

		return "handleError";
	}

	@GetMapping("async")
	public String async(Model model) throws Exception {

		CompletableFuture<List<Website>> websitesOne = new CompletableFuture<List<Website>>();
		CompletableFuture<List<Website>> websitesTwo = new CompletableFuture<List<Website>>();

		// try {
		websitesOne = websitesService.getAllWebsitesAsync();
		websitesTwo = websitesService.getAllWebsitesAsync();
		CompletableFuture.allOf(websitesOne, websitesTwo).get();
		// } catch (Exception e) {
		// model.addAttribute("error", e.toString());
		// }

		model.addAttribute("websitesOne", websitesOne.get());
		model.addAttribute("websitesTwo", websitesTwo.get());
		return "async";
	}

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		model.addAttribute("error", error != null);
		model.addAttribute("logout", logout != null);

		return "login";
	}

}
