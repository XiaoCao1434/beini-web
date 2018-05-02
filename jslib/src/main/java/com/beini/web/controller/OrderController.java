package com.beini.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beini.core.enums.ResultEnum;
import com.beini.core.utils.ResultVOUtil;
import com.beini.core.vo.ResultVO;
import com.beini.web.feignClient.order.OrderFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
@SuppressWarnings("rawtypes")
public class OrderController {
	@Autowired
	private OrderFeignClient orderFeignClient;
	/**
	 * 订单详情页
	 * @param id 订单ID
	 * @return
	 */
	@ApiOperation(value="订单详情页")
	@GetMapping("/{id}")
	/*方式一：步骤3*/
	/*@HystrixCommand(fallbackMethod="getProductError")*/
	public ResultVO getProductOne(@PathVariable("id")String id) {
		System.out.println("getOrderOne: "+ id);
		return orderFeignClient.findById(id);
	}
	/*方式一：步骤4*/
	/*public ResultVO getProductError(String id) {
		System.out.println("getProductError error: "+ id);
		return ResultVOUtil.error(ResultEnum.ORDER_NOT_EXIST);
	}*/
	/**
	 * 订单列表
	 * @param pageNo 订单页码
	 * @param pageSize 订单每页显示条数
	 * @return 订单列表清单
	 */
	@ApiOperation(value="订单列表")
	@GetMapping("/")
	public ResultVO getProductPage(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
		return orderFeignClient.findByPage(pageNo, pageSize);
	}
}
