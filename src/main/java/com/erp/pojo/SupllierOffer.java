package com.erp.pojo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : DongChenchen
 * @date : 2019/8/31  17:40
 * 供应商报价信息
 * 一个询价单对应多个供应商报价信息（excel表中 询价统计），
 */
@Data
@Entity
@Table(name = "t_supplier_offer")
public class SupllierOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name="inquiryOfferSheetId")
    private Long inquiryOfferSheetId;//关联询价单
    @Column(name="supplierId")
    private Long supplierId;//关联供应商
    @Column(name="contact",length = 20)
    private String contact;//接触人
    @Column(name="amount")
    private BigDecimal amount;//总金额
    @Column(name="offerTime")
    private Date offerTime;//报价时间
    @Column(name="tax")
    private String tax;//税
    @Column(name="transport")
    private String transport;//运
    @Column(name="remark")
    private String remark;//备注

    public SupllierOffer() {
    }

    public SupllierOffer(Long id) {
        this.id = id;
    }
}
