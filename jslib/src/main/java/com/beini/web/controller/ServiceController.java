package com.beini.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beini.web.manager.OrderProductManager;

@RestController
@RequestMapping("/service")
public class ServiceController {
	@Autowired
	private OrderProductManager orderProductManager;
	
	@RequestMapping("/id")
	public String index(String id) {
		System.out.println(orderProductManager.getProductsByOrderId("11"));
		return "index";
	}
}
