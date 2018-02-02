package com.intuit.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intuit.domain.Game;

@Controller
public class GameController {

	@PostMapping("/play")
	public String play(@RequestParam int guess,HttpSession session) {
		Game game = (Game)session.getAttribute("game");
		game.play(guess);
		if(game.isGameOver())
			return "over";
		return "index";
	}
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("game") == null) {
			session.setAttribute("game", new Game());
		}
		return "index";
	}
}
