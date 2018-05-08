package com.beini.web.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beini.core.utils.ResultVOUtil;
import com.beini.core.vo.ResultVO;
import com.beini.order.entity.Order;
import com.beini.product.entity.Product;
import com.beini.web.feignClient.order.OrderFeignClient;
import com.beini.web.feignClient.product.ProductFeignClient;

@Service
public class OrderProductManagerImpl implements OrderProductManager{
	@Autowired
	private OrderFeignClient orderFeignClient;
	@Autowired
	private ProductFeignClient productFeignClient;
	@Override
	@SuppressWarnings("unchecked")
	public ResultVO<String> getProductsByOrderId(String orderId) {
		ResultVO<Order> orderVO = orderFeignClient.findById(orderId);
		ResultVO<Product> productVO = productFeignClient.findById(orderId);
		System.out.println(orderVO);
		System.out.println(productVO);
		return ResultVOUtil.success();
	}
}
