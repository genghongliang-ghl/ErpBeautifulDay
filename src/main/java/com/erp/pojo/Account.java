package com.erp.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : DongChenchen
 * @date : 2019/8/31  16:22
 * 公司银行账户信息（excel中 公司有多账户）
 */
@Data
@Entity
@Table(name = "t_product")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(name="companyId")
    private Long companyId;//公司ID
    @Column(name="dutyParagraph",length = 40)
    private String dutyParagraph;//税号
    @Column(name="bankOfDeposit",length = 40)
    private String bankOfDeposit;//开户行
    @Column(name="accountNum",length = 40)
    private String accountNum;//账号

    public Account() {
    }
}
