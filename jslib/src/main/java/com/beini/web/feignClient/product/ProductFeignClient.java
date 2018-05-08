package com.beini.web.feignClient.product;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.beini.core.vo.ResultVO;
/**
 * 声明商品服务中的商品模块控制器接口
 * @author lb_chen
 * @date 2018-04-19 13:10
 */
@FeignClient(name = "product")
@SuppressWarnings("rawtypes")
public interface ProductFeignClient {
	/**
	 * 根据商品ID获取商品信息
	 * 
	 * @see com.beini.product.controller.ProductController.findById(id)
	 * @param id
	 *            商品ID
	 * @return 商品信息
	 */
	@GetMapping("/product/product/{id}")
	public ResultVO findById(@PathVariable(value = "id") String id);

	/**
	 * 根据分页信息获取商品分页信息
	 * 
	 * @param pageNo
	 *            第几页
	 * @param pageSize
	 *            每页条数
	 * @return 商品分页信息
	 */
	@GetMapping("/product/product/")
	public ResultVO findByPage(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize);
}
