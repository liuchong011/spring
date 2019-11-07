package com.example.apim.service.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/apim")
public class ApimController {

	protected Logger logger = LoggerFactory.getLogger(ApimController.class);

	@RequestMapping(value = "/service")
	public JSONObject service(HttpServletResponse response, 
			@RequestParam(value = "status" , required = false ) String status, 
			@RequestParam(value = "delay" , required = false ) String delay)
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

		return result;
	}

}
