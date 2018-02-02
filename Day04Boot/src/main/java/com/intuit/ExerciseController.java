package com.intuit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExerciseController {

	@PostMapping("/process")
	public String processForm(@RequestParam("firstname") String name,Model model,
			HttpSession session, HttpServletRequest request, 
			HttpServletResponse response) {
		String message = "Hello " + name;
		session.setAttribute("cool", "cold in session");
		model.addAttribute("message",message);
		return "result";
	}
	
	@GetMapping("/")
	public String loadForm() {
		return "form";
	}
}
