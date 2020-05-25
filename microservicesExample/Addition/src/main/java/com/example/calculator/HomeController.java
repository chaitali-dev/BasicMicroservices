package com.example.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	Environment environment;

	@GetMapping("add/{num1}/{num2}")
	public ResponseBean add(@PathVariable int num1 , @PathVariable int num2) {
		
		ResponseBean res = new ResponseBean();
		res.setPort(environment.getProperty("local.server.port"));
		res.setResult(String.valueOf(num1 + num2));
		res.setStatus("success");
		
		return res;
	}
}
