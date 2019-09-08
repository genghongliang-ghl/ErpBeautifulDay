package com.erp.vo;

import com.erp.pojo.*;
import lombok.Data;

import java.util.List;

/**
 * @author : DongChenchen
 * @date : 2019/9/6 23:42
 */
@Data
public class OrderMo extends Order {
    private Customer customer;//客戶/需求方（客户表）
    private FinancialStatistics financialStatistics;
    private List<Logistics> logisticsList;//关联的物流信息
    private List<OrderItem> orderItemList;
}
