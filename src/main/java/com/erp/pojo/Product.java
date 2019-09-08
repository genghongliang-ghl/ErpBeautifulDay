package com.erp.pojo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author : DongChenchen
 * @date : 2019/8/31  16:27
 *  商品二级分类  信息表
 *  一个订单项会有一个产品
 */
@Data
@Entity
@Table(name = "t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name="name",length = 25)
    private String name;//名称（二级分类）
    @Column(name="subject",length = 125)
    private String subject;//主题（一级分类）
    @Column(name="pn",length = 25)
    private String pn;//P/N号
    @Column(name="price",length = 25)
    private BigDecimal price;//单价
    @Column(name="brand",length = 25)
    private String brand;//品牌
    @Column(name="spec",length = 25)
    private String spec;//规格型号
    @Column(name="amount",length = 25)
    private Long amount;//数量
    @Column(name="remark")
    private String remark;//备注

    public Product() {
    }
    public Product(Long id) {
        this.id = id;
    }
}
