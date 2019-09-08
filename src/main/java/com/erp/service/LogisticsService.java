package com.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.LogisticsMapper;
import com.erp.mapper.OrderMapper;
import com.erp.pojo.Logistics;
import com.erp.pojo.Order;
import com.erp.vo.LogisticsMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


/**
 * @author : DongChenchen
 * @date : 2019/9/6 0:22
 */
@Service
public class LogisticsService {
    @Autowired
    private LogisticsMapper logisticsMapper;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 根据物流id获取带有关联对象的 物流信息
     * @param id
     * @return
     */
    public LogisticsMo findOneCacheById(Long id){
        Logistics logistics = logisticsMapper.selectByPrimaryKey(new Logistics(id));
        LogisticsMo logisticsMo = JSONObject.parseObject(JSONObject.toJSONString(logistics), LogisticsMo.class);
        Order order = orderMapper.selectByPrimaryKey(new Order(logistics.getOrderId()));
        logisticsMo.setOrder(order);
        return logisticsMo;
    }

}
