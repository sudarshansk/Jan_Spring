package com.intuit;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//http://localhost:8080/greet/John
//http://localhost:8080/greet/Ram
//http://localhost:8080/greet/Sachin

//http://localhost:8080/bye?name=Sam
//http://localhost:8080/bye?name=John



@RestController
public class HelloController {

	@RequestMapping("/bye")
	public String bye(@RequestParam("name")String name) {
		return "Bye Bye " + name;
	}
	
	@RequestMapping("/greet/{name}")
	public String greet(@PathVariable("name") String name) {
		return "Hello " + name;
	}
}
