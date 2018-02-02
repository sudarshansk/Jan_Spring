package com.intuit.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intuit.domain.Game;

@Controller
public class GameController {

	@Autowired
	private Game game;
	@PostMapping("/play")
	public String play(@RequestParam int guess,HttpSession session) {
		game.play(guess);
		System.out.println("MEssage: " + game.getMessage());
		System.out.println("Attempts: " + game.getAttempts());
		if(game.isGameOver())
			return "over";
		return "index";
	}
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		return "index";
	}
	
//	@PostMapping("/play")
//	public String play(@RequestParam int guess,HttpSession session) {
//		Game game = (Game)session.getAttribute("game");
//		game.play(guess);
//		if(game.isGameOver())
//			return "over";
//		return "index";
//	}
//	
//	@RequestMapping("/")
//	public String index(HttpSession session) {
//		if(session.getAttribute("game") == null) {
//			session.setAttribute("game", new Game());
//		}
//		return "index";
//	}
}
