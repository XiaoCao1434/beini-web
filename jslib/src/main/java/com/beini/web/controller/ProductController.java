package com.beini.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beini.core.vo.ResultVO;
import com.beini.web.feignClient.product.ProductFeignClient;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product")
@SuppressWarnings("rawtypes")
public class ProductController {
	@Autowired
	private ProductFeignClient productFeignClient;
	/**
	 * 商品详情页
	 * @param id 商品ID
	 * @return
	 */
	@ApiOperation(value="商品详情页")
	@GetMapping("/{id}")
	public ResultVO getProductOne(@PathVariable("id")String id) {
		System.out.println("getProductOne: "+ id);
		return productFeignClient.findById(id);
	}
	/**
	 * 商品列表
	 * @param pageNo 商品页码
	 * @param pageSize 商品每页显示条数
	 * @return 商品列表清单
	 */
	@ApiOperation(value="商品列表")
	@GetMapping("/")
	public ResultVO getProductPage(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
		return productFeignClient.findByPage(pageNo, pageSize);
	}
}
