package com.erp.vo;

import com.erp.pojo.Order;
import com.erp.pojo.OrderItem;
import com.erp.pojo.Product;
import com.erp.pojo.Supplier;
import lombok.Data;

import javax.persistence.Column;

/**
 * @author : DongChenchen
 * @date : 2019/9/3  12:46
 */
@Data
public class OrderItemMo extends OrderItem {
    private Supplier supplier;//供应商
    private Product product;//关联产品表
    private Order order;//所属订单，关联订单表
}
