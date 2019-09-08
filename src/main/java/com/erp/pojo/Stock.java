package com.erp.pojo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : DongChenchen
 * @date : 2019/8/31  17:21
 * 库存管理（跟订单没关系，财务汇总时，显示库存金额）
 *  货品，入库时间，数量，价格，位置
 */
@Data
@Entity
@Table(name = "t_stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name="product")
    private String product;//货品
    @Column(name="time")
    private Date time;//入库时间
    @Column(name="amount")
    private BigDecimal amount;//数量
    @Column(name="price")
    private BigDecimal price;//价格
    @Column(name="position")
    private String position;//位置
    @Column(name="empId")
    private Long empId;//操作人
    @Column(name="remark")
    private String remark;//备注

    public Stock() {
    }
    public Stock(Long id) {
        this.id = id;
    }
}
