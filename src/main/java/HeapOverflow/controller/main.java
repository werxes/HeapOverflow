package HeapOverflow.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import HeapOverflow.domains.User;

@Controller
public class main {

	@GetMapping("/")
	public String index(@AuthenticationPrincipal User user, Model model) {

		model.addAttribute("username", user.getUsername());

		return "index";
	}

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		model.addAttribute("error", error != null);
		model.addAttribute("logout", logout != null);

		return "login";
	}

}
