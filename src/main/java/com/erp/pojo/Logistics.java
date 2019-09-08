package com.erp.pojo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : DongChenchen
 * @date : 2019/8/31  18:57
 * 物流信息
 * 一个订单可能多个物流信息
 * 供应商->公司->客户
 * 供应商->客户
 * 1.excel表中询价统计 有物流信息
 * 2.excel表中PO 有物流信息
 *
 */
@Data
@Entity
@Table(name = "t_logistics")
public class Logistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name="orderId")
    private Long orderId;//关联的订单
    @Column(name="companyName",length = 40)
    private String companyName;//物流公司
    @Column(name="startPersion",length = 20)
    private String startPersion;//发货人
    @Column(name="endPersion",length = 20)
    private String endPersion;//收货人
    @Column(name="startPosition",length = 40)
    private String startPosition;//发货地点
    @Column(name="endPosition",length = 40)
    private String endPosition;//到货地点
    @Column(name="startTime")
    private Date startTime;//发货时间
    @Column(name="endTime")
    private Date endTime;//到货时间
    @Column(name="price")
    private BigDecimal price;//运费
    @Column(name="packagePrice")
    private BigDecimal packagePrice;//包装费
    @Column(name="otherPrice")
    private BigDecimal otherPrice;//其他费用

    public Logistics() {
    }

    public Logistics(Long id) {
        this.id = id;
    }
}
