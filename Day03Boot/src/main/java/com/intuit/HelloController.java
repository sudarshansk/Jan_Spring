package com.intuit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


//http://localhost:8080/greet/John
//http://localhost:8080/greet/Ram
//http://localhost:8080/greet/Sachin

//http://localhost:8080/bye?name=Sam
//http://localhost:8080/bye?name=John



@RestController
public class HelloController {

	@Value("${mathservice.url}")
	private String mathServiceUrl;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	@GetMapping("/domath/{num1}/{num2}")
	public MathResult doMath(@PathVariable double num1,@PathVariable double num2) {
		MathResult mathResult = new MathResult();
		mathResult.setNumber1(num1);
		mathResult.setNumber2(num2);
		
		String url = mathServiceUrl + "/add/" + num1 + "/" + num2;
		double sum = restTemplate.getForObject(url, Double.class);
		
		mathResult.setSum(sum);
		return mathResult;
	}
	
	
	
	
	@RequestMapping("/bye")
	public String bye(@RequestParam("name")String name) {
		return "Bye Bye " + name;
	}
	
	@RequestMapping("/greet/{name}")
	public String greet(@PathVariable("name") String name) {
		return "Hello " + name;
	}
}
