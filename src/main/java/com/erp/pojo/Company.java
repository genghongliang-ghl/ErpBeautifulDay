package com.erp.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : DongChenchen
 * @date : 2019/8/31  16:51
 * 公司信息表
 */
@Data
@Entity
@Table(name = "t_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name="name",length = 25)
    private String name;//名称
    @Column(name="address",length = 125)
    private String address;//地址
    @Column(name="tel",length = 25)
    private String tel;//电话
    @Column(name="email",length = 25)
    private String email;
    @Column(name="website",length = 25)
    private String website;//官网

    public Company() {
    }

    public Company(Long id) {
        this.id = id;
    }
}
