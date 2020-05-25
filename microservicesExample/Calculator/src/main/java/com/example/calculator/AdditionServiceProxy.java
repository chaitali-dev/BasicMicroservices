package com.example.calculator;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="addition-service")
@RibbonClient(name="addition-service")
public interface AdditionServiceProxy {

	@GetMapping("add/{num1}/{num2}")
	  public ResponseBean callAddition(@PathVariable("num1") int num1, @PathVariable("num2") int num2);
}
