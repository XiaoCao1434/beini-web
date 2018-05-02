package com.beini.web.feignClient.order.impl;

import org.springframework.stereotype.Component;

import com.beini.core.enums.ResultEnum;
import com.beini.core.utils.ResultVOUtil;
import com.beini.core.vo.ResultVO;
import com.beini.web.feignClient.order.OrderFeignClient;

import lombok.extern.slf4j.Slf4j;

/**
 * 订单的远程调用服务fallback实现类
 * @author lb_chen
 */
@Component
@SuppressWarnings("rawtypes")
@Slf4j
public class OrderFeignClientFallback implements OrderFeignClient {
	@Override
	public ResultVO findById(String id) {
		log.info("OrderFeignClientImpl 中：findById("+id+")");
		return ResultVOUtil.error(ResultEnum.ORDER_NOT_EXIST);
	}
	@Override
	public ResultVO findByPage(Integer pageNo,Integer pageSize) {
		log.info("OrderFeignClientImpl 中：findByPage("+pageNo+","+pageSize+")");
		return ResultVOUtil.error(ResultEnum.ORDER_NOT_EXIST);
	}

}
