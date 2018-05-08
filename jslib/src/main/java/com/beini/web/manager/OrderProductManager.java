package com.beini.web.manager;

import com.beini.core.vo.ResultVO;

public interface OrderProductManager {
	
	public ResultVO<String> getProductsByOrderId(String orderId);
}
