package com.erp.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : DongChenchen
 * @date : 2019/8/31  16:47
 *  订单项 一个订单对应多个订单项
 *  一个订单项 关联一个二级分类商品
 *  客户返回订单时，可能有不要的订单项，需修改confirm的状态
 */
@Data
@Entity
@Table(name = "t_order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name="supplierId")
    private Long supplierId;//供应商
    @Column(name="productId")
    private Long productId;//关联产品表
    @Column(name="orderId")
    private Long orderId;//所属订单，关联订单表
    @Column(name="confirm",length = 10)
    private Integer confirm;//客户确认:0，未确认，1确认购买，2 确认不购买

    public OrderItem() {
    }
    public OrderItem(Long id) {
        this.id = id;
    }
}
