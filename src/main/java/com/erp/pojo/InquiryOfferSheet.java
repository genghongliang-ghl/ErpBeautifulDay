package com.erp.pojo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : DongChenchen
 * @date : 2019/8/31  16:24
 *  客户询价单,报价单(联系客户，商品，订单项)
 *  询价单对应一个二级分类商品，
 *  询价单对应多个供应商报价信息（excel表中 询价统计），
 */
@Data
@Entity
@Table(name = "t_inquery_sheet")
public class InquiryOfferSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name="customerId",length = 25)
    private Long customerId;//客戶/需求方（客户表）
    @Column(name="introducerName",length = 125)
    private String introducerName;//中间介绍人(只是个姓名，不关联其他表)
    @Column(name="orderId")
    private Long orderId;//关联订单(方便查询)
    @Column(name="orderItemId")
    private Long orderItemId;//关联订单项表
    @Column(name="productId")
    private Long productId;//关联产品表
    @Column(name="queryTime")
    private Date queryTime;//询价时间
    @Column(name="status",length = 25)
    private Integer status;//是否报价     已报/未报/已报未成单/报不了

    @Column(name="po",length = 25)
    private Integer po;//是否PO
    @Column(name="payTime")
    private Date payTime;//给供应商付款时间
    @Column(name="amount")
    private BigDecimal amount;//付出金额
    @Column(name="payToPerson",length = 25)
    private String payToPerson;//付给谁了
    @Column(name="payStyle",length = 25)
    private String payStyle;//付款方式
    @Column(name="remark")
    private String remark;//说明

    @Column(name="logisticsId")
    private Long logisticsId;//关联一个物流信息
    //询价后 会确认选择哪个供应商报价（采购）
    @Column(name="supllierOfferId")
    private Long supllierOfferId;//关联一个供应商报价信息
    @Column(name="purchase",length = 125)
    private String purchase;//采购合同编号
    //===========================报价单信息（excel中的报价单模板）===========================
    //PRODUCT	P/N	QTY.	UNIT PRICE	AMOUNT	REMARKS
    @Column(name="offerNum")
    private String offerNum;//报价编号
    @Column(name="offerQTY")
    private BigDecimal offerQTY;//数量
    @Column(name="offerPrice")
    private BigDecimal offerPrice;//单价
    @Column(name="offerAmount")
    private BigDecimal offerAmount;//总金额
    @Column(name="offerRemark")
    private String offerRemark;//备注

    public InquiryOfferSheet() {
    }

    public InquiryOfferSheet(Long id) {
        this.id = id;
    }
}
