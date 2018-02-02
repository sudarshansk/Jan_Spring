package com.intuit.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Game {
	private int target;
	private int attempts;
	private String message;
	private boolean gameOver;
	
	public Game() {
		target = (int)(Math.random()*100);
		System.out.println("Target is " + target);
	}
	
	public void play(int guess) {
		attempts++;
		if(guess > target)
			message = "Aim Lower";
		else if(guess < target)
			message = "Aim Higher";
		else {
			message = "You've got it!!!";
			gameOver = true;
		}
			
	}
	
	public boolean isGameOver() {
		return gameOver;
	}

	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
