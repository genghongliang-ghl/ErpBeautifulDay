package com.erp.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : DongChenchen
 * @date : 2019/8/31  16:53
 * 买家信息表(公司/个人)
 */
@Data
@Entity
@Table(name = "t_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name="name",length = 25)
    private String name;//买家名称
    @Column(name="address",length = 125)
    private String address;//买家地址
    @Column(name="tel",length = 25)
    private String tel;//买家电话
    @Column(name="email",length = 25)
    private String email;

    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }

}
