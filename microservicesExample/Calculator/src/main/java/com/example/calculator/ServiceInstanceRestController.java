package com.example.calculator;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
class ServiceInstanceRestController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private AdditionServiceProxy proxy;

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
	
	
	@GetMapping("calculate/{mathFunction}/{num1}/{num2}")
	public ResponseBean mathsFunction(@PathVariable String mathFunction ,@PathVariable int num1 , @PathVariable int num2) {
		System.out.println("mathFunction:"+mathFunction);		
		return proxy.callAddition(num1, num2);
	}
	
	/*
	 * @GetMapping(
	 * "/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}") public
	 * CurrencyConversionBean convertCurrencyFeign(@PathVariable String
	 * from, @PathVariable String to,
	 * 
	 * @PathVariable BigDecimal quantity) {
	 * 
	 * CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
	 * 
	 * logger.info("{}", response);
	 * 
	 * return new CurrencyConversionBean(response.getId(), from, to,
	 * response.getConversionMultiple(), quantity,
	 * quantity.multiply(response.getConversionMultiple()), response.getPort()); }
	 */

}
