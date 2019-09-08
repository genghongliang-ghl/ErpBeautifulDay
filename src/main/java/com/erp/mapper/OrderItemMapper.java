package com.erp.mapper;

import com.erp.pojo.OrderItem;
import com.erp.vo.OrderItemMo;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author : DongChenchen
 * @date : 2019/9/3  12:52
 */
public interface OrderItemMapper extends Mapper<OrderItem> {
    public OrderItemMo fetchListByOrderId(Long orderId);
}
