package com.intuit;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


//Like creating beans.xml file in Code
@Configuration
@EnableWebMvc //<mvc:annotation-driven/>
public class Day04Configuration extends WebMvcConfigurerAdapter{

	@Bean(name="myprops")
	public Map<String, String> getMyProps() {
		Map<String,String> map = new HashMap<>();
		map.put("Scala", "60 min");
		map.put("Groovy", "50 min");
		return map;
	}
	
	@Bean
	public ViewResolver createViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer 
			configurer) {
		configurer.enable();
	}	
	
}
