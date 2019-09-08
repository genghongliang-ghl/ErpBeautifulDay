package com.erp.pojo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : DongChenchen
 * @date : 2019/8/31  17:27
 * 运营管理（财务汇总时，显示金额）
 * 时间，做了什么，花多少钱，流水
 */
@Data
@Entity
@Table(name = "t_business")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name="empId")
    private Long empId;//员工
    @Column(name="time")
    private Date time;//时间
    @Column(name="things",length = 40)
    private String things;//做了什么
    @Column(name="amount")
    private BigDecimal amount;//花多少钱
    @Column(name="remark")
    private String remark;//备注

    public Business() {
    }
}
