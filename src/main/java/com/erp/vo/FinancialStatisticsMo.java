package com.erp.vo;

import com.erp.pojo.FinancialStatistics;
import com.erp.pojo.Logistics;
import com.erp.pojo.Order;
import lombok.Data;

/**
 * @author : DongChenchen
 * @date : 2019/9/6 21:12
 */
@Data
public class FinancialStatisticsMo extends FinancialStatistics {
    private Order order;//关联的订单
}
