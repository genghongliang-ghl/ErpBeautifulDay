package com.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.*;
import com.erp.pojo.*;
import com.erp.vo.LogisticsMo;
import com.erp.vo.OrderMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @author : DongChenchen
 * @date : 2019/9/6 21:22
 */
@Service
public class OrderService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private LogisticsMapper logisticsMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private FinancialStatisticsMapper financialStatisticsMapper;

    /**
     * 根据订单id获取带有关联对象的,只查一对一 订单信息
     * @param id
     * @return
     */
    public OrderMo findOneCacheById(Long id){
        Order order = orderMapper.selectByPrimaryKey(new Order(id));
        OrderMo logisticsMo = JSONObject.parseObject(JSONObject.toJSONString(order), OrderMo.class);
        Customer cus = customerMapper.selectOneByExample(new Customer(order.getCustomerId()));
        Example exam1=new Example(Logistics.class);
        exam1.createCriteria().andEqualTo("orderId",id);
        List<Logistics> logs = logisticsMapper.selectByExample(exam1);
        logisticsMo.setCustomer(cus);
        logisticsMo.setLogisticsList(logs);
        Example exam=new Example(OrderItem.class);
        exam.createCriteria().andEqualTo("orderId",id);
        List<OrderItem> orderItems = orderItemMapper.selectByExample(exam);
        logisticsMo.setOrderItemList(orderItems);
        FinancialStatistics fs = financialStatisticsMapper.selectByPrimaryKey(new FinancialStatistics(order.getId()));
        logisticsMo.setFinancialStatistics(fs);
        return logisticsMo;
    }



}
