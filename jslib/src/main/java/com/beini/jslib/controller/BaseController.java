package com.beini.jslib.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	@RequestMapping("/index")
	public String index(Map<String,String> model) {
		return "index";
	}
	@RequestMapping("/simple-handlebars")
	public String simple_handlebars(Map<String,String> model) {
		return "simple-handlebars";
	}
}
