package com.erp.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : DongChenchen
 * @date : 2019/8/31  16:37
 *  订单（客户，供应商）
 *  对应excel中的po表的一条记录
 *  一个订单会有多个订单项，会有多个询价单、报价单（InquiryOfferSheet）
 *  一个订单可能会有多个物流信息（Logistics）
 *  一个订单会有一个利润统计（FinancialStatistics）
 *
 */
@Data
@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name="orderNo")
    private String orderNo;//订单编号
    @Column(name="customerId",length = 25)
    private Long customerId;//客戶/需求方（客户表）
    //@Column(name="logisticsId",length = 25)//一个订单可能会有多个物流信息
    //private Long logisticsId;//关联物流信息
    @Column(name="financialStatisticsId",length = 25)
    private Long financialStatisticsId;//关联利润统计
    private Integer status;//订单状态

    public Order() {
    }

    public Order(Long id) {
        this.id=id;
    }
}
