package com.beini.web.feignClient.product;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="product")
public interface ProductFeignClient {
	@GetMapping("/product/product/{id}")
	public String findById(@RequestParam("id")String id);
}
