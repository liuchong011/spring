package com.example.apim.service.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@CrossOrigin
@RequestMapping("{p1}")
public class AllController {

	protected Logger logger = LoggerFactory.getLogger(AllController.class);

	@RequestMapping(value = "{p2}")
	public JSONObject service(HttpServletResponse response, 
			@RequestParam(value = "status" , required = false ) String status, 
			@RequestParam(value = "delay" , required = false ) String delay,
			@PathVariable(value = "p1" , required = false ) String p1,
			@PathVariable(value = "p2" , required = false ) String p2)
					throws NumberFormatException, InterruptedException {
		this.logger.info("service start");
		
		JSONObject result = new JSONObject();

		if (status != null) {
			response.setStatus(Integer.parseInt(status));
			result.put("status", status);
		}
		
		if (delay != null) {
			Thread.sleep(Long.parseLong(delay));
			result.put("delay", delay);
		}
		
		result.put("p1", p1);
		result.put("p2", p2);

		return result;
	}
	
	@RequestMapping(value = "")
	public JSONObject service1(HttpServletResponse response, 
			@RequestParam(value = "status" , required = false ) String status, 
			@RequestParam(value = "delay" , required = false ) String delay,
			@PathVariable(value = "p1" , required = false ) String p1)
					throws NumberFormatException, InterruptedException {
		this.logger.info("service start");
		
		JSONObject result = new JSONObject();

		if (status != null) {
			response.setStatus(Integer.parseInt(status));
			result.put("status", status);
		}
		
		if (delay != null) {
			Thread.sleep(Long.parseLong(delay));
			result.put("delay", delay);
		}
		
		result.put("p1", p1);

		return result;
	}
	
	@RequestMapping(value = "{p2}/{p3}")
	public JSONObject service3(HttpServletResponse response, 
			@RequestParam(value = "status" , required = false ) String status, 
			@RequestParam(value = "delay" , required = false ) String delay,
			@PathVariable(value = "p1" , required = false ) String p1,
			@PathVariable(value = "p2" , required = false ) String p2,
			@PathVariable(value = "p3" , required = false ) String p3)
					throws NumberFormatException, InterruptedException {
		this.logger.info("service start");
		
		JSONObject result = new JSONObject();

		if (status != null) {
			response.setStatus(Integer.parseInt(status));
			result.put("status", status);
		}
		
		if (delay != null) {
			Thread.sleep(Long.parseLong(delay));
			result.put("delay", delay);
		}
		
		result.put("p1", p1);
		result.put("p2", p2);
		result.put("p3", p2);

		return result;
	}

}
