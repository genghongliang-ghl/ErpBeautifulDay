package com.erp.pojo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : DongChenchen
 * @date : 2019/8/31  18:31
 * 订单为最后一个状态时，进行利润统计 对应excel表中PO 最后几列
 *     //发运时间	付款时间	进账	结汇时间	结汇进账	买入（支付供应商货款）
 *     // 付货款时间	发货时间	包装	物流		到货		备注
 *     // 其他支出	总报价	总成本	毛利润	利率毛
 */
@Data
@Entity
@Table(name = "t_financial_statistics")
public class FinancialStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name="orderId")
    private Long orderId;//关联订单表
    @Column(name="payTime")
    private Date payTime;//付款时间
    @Column(name="payAmount")
    private BigDecimal payAmount;//进账(金额)
    @Column(name="exchangeTime")
    private Date exchangeTime;//结汇时间
    @Column(name="exchangeAmount")
    private BigDecimal exchangeAmount;//结汇进账
    @Column(name="supplierAmount")
    private BigDecimal supplierAmount;//买入（支付供应商货款）
    @Column(name="otherAmount")
    private BigDecimal otherAmount;//其他支出

    public FinancialStatistics() {
    }

    public FinancialStatistics(Long id) {
        this.id = id;
    }
}
