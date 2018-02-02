package com.intuit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

	@GetMapping("/home")
	public String viewHome(Model model) {
		model.addAttribute("message", "Welcome to Spring Training");
		return "homepage";
	}
}
