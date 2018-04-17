package com.beini.web.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beini.core.entity.product.Product;
import com.beini.core.service.product.ProductService;
import com.beini.core.utils.ResultVOUtil;
import com.beini.core.vo.ResultVO;

@RestController
@RequestMapping("/product/product/")
@SuppressWarnings({ "rawtypes"})
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("{id}")
	public ResultVO findById(@PathVariable("id")String id) {
		Product product = productService.findById(id);
		return ResultVOUtil.success(product);
	}
	
	@GetMapping("")
	public ResultVO findByPage(@RequestParam(name="pageNo",required=false,defaultValue="1")Integer pageNo,
			@RequestParam(name="pageSize",required=false,defaultValue="10")Integer pageSize) {
		PageRequest request = new PageRequest(pageNo - 1, pageSize);
		Page<Product> page = productService.findAll(request);
		return ResultVOUtil.success(page);
	}
	@PutMapping
	public ResultVO update(Product product) {
		if(productService.update(product)== null) {
			return ResultVOUtil.error(501, "更新失败");
		}else {
			return ResultVOUtil.success();
		}
	}
	@PostMapping
	public ResultVO save(Product product) {
		if(productService.save(product)== null) {
			return ResultVOUtil.error(502, "新增失败");
		}else {
			return ResultVOUtil.success();
		}
	}
	@DeleteMapping("{id}")
	public ResultVO deleteById(@PathVariable("id")String id) {
		try {
			productService.delete(id);
			return ResultVOUtil.success();
		}catch(Exception e) {
			return ResultVOUtil.error(503, "删除失败");
		}
	}
}
