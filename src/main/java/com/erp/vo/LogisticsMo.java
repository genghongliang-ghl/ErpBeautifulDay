package com.erp.vo;

import com.erp.pojo.Logistics;
import com.erp.pojo.Order;
import lombok.Data;

/**
 * @author : DongChenchen
 * @date : 2019/9/6 22:26
 */
@Data
public class LogisticsMo extends Logistics {
    private Order order;//关联的订单
}
