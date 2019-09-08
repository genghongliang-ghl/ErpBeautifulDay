package com.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.*;
import com.erp.pojo.*;
import com.erp.vo.OrderItemMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @author : DongChenchen
 * @date : 2019/9/6 22:24
 */
@Service
public class OrderItemService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    /**
     * 根据订单项id获取带有关联对象的 订单项信息
     * @param id
     * @return
     */
    public OrderItemMo findOneCacheById(Long id){
        OrderItem logistics = orderItemMapper.selectByPrimaryKey(new OrderItem(id));
        OrderItemMo logisticsMo = JSONObject.parseObject(JSONObject.toJSONString(logistics), OrderItemMo.class);
        Product pro = productMapper.selectOneByExample(new Product(logistics.getProductId()));
        Supplier sup = supplierMapper.selectOneByExample(new Supplier(logistics.getSupplierId()));
        Order ord = orderMapper.selectOneByExample(new Order(logistics.getOrderId()));
        logisticsMo.setProduct(pro);
        logisticsMo.setSupplier(sup);
        logisticsMo.setOrder(ord);
        return logisticsMo;
    }
    /**
     * 根据订单项id获取 订单信息
     * @param id
     * @return
     */
    public Order findOrderById(Long id){
        OrderItem item = orderItemMapper.selectByPrimaryKey(new OrderItem(id));
        return orderMapper.selectOneByExample(new Order(item.getOrderId()));
    }
    /**
     * 根据订单id获取 全部的订单项信息
     * @param orderId
     * @return
     */
    public List<OrderItem> findAllByOrderId(Long orderId){
        Example emp=new Example(OrderItem.class);
        emp.createCriteria().andEqualTo("orderId",orderId);
        return orderItemMapper.selectByExample(emp);
    }

}
