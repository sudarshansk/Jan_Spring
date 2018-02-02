package com.intuit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExerciseController {

	@PostMapping("/process")
	public String processForm(@RequestParam("firstname") String name,Model model) {
		String message = "Hello " + name;
		model.addAttribute("message",message);
		return "result";
	}
	
	@GetMapping("/")
	public String loadForm() {
		return "form";
	}
}
