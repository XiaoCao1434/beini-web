package com.beini.web.feignClient.product;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.beini.core.vo.ResultVO;

@SuppressWarnings("rawtypes")
@FeignClient(name="product")
public interface ProductFeignClient {
	@GetMapping("/product/product/{id}")
	public ResultVO findById(@PathVariable(value="id")String id);
}
