package com.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.FinancialStatisticsMapper;
import com.erp.mapper.LogisticsMapper;
import com.erp.mapper.OrderMapper;
import com.erp.pojo.FinancialStatistics;
import com.erp.pojo.Logistics;
import com.erp.pojo.Order;
import com.erp.vo.FinancialStatisticsMo;
import com.erp.vo.LogisticsMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


/**
 * @author : DongChenchen
 * @date : 2019/9/6 23:12
 */
@Service
public class FinancialStatisticsService {
    @Autowired
    private FinancialStatisticsMapper financialStatisticsMapper;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 根据利润统计id获取带有关联对象的 利润统计信息
     * @param id
     * @return
     */
    public FinancialStatisticsMo findOneCacheById(Long id){
        FinancialStatistics logistics = financialStatisticsMapper.selectByPrimaryKey(new Logistics(id));
        FinancialStatisticsMo logisticsMo = JSONObject.parseObject(JSONObject.toJSONString(logistics), FinancialStatisticsMo.class);
        Order order = orderMapper.selectByPrimaryKey(logistics.getOrderId());
        logisticsMo.setOrder(order);
        return logisticsMo;
    }

}
