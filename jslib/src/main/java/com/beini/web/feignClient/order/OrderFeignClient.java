package com.beini.web.feignClient.order;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.beini.core.vo.ResultVO;
import com.beini.web.feignClient.order.impl.OrderFeignClientFallback;

/**
 * 声明订单服务中的订单模块控制器接口
 * @author lb_chen
 * @date 2018-04-19 13:10
 */
@FeignClient(name = "order",fallback=OrderFeignClientFallback.class)
@RequestMapping("/order/order/")
@SuppressWarnings("rawtypes")
public interface OrderFeignClient {
	/**
	 * 根据订单ID获取订单信息
	 * 
	 * @see com.beini.order.controller.OrderController.findById(id)
	 * @param id
	 *            订单ID
	 * @return 订单信息
	 */
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public ResultVO findById(@PathVariable(value = "id") String id);

	/**
	 * 根据分页信息获取订单分页信息
	 * 
	 * @param pageNo
	 *            第几页
	 * @param pageSize
	 *            每页条数
	 * @return 订单分页信息
	 */
	@RequestMapping(value="",method=RequestMethod.GET)
	public ResultVO findByPage(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize);
}
