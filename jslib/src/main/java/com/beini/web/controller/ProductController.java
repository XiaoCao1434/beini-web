package com.beini.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beini.core.vo.ResultVO;
import com.beini.web.feignClient.product.ProductFeignClient;

@RestController
@RequestMapping("/product")
@SuppressWarnings("rawtypes")
public class ProductController {
	@Autowired
	private ProductFeignClient productFeignClient;
	@GetMapping("/{id}")
	public ResultVO getProductOne(@PathVariable("id")String id) {
		System.out.println("getProductOne: "+ id);
		return productFeignClient.findById(id);
	}
}
