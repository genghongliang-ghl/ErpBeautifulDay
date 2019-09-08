package com.erp.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : DongChenchen
 * @date : 2019/8/31  16:21
 * 公司员工信息表
 */
@Data
@Entity
@Table(name = "t_employee")
public class Employee {
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
    @Column(name="job",length = 25)
    private String job;//职位
    @Column(name="department",length = 25)
    private String department;//所属部门（部门表可后期加）
    @Column(name="role",length = 25)
    private String role;//系统角色（角色，权限表可后期加）

    public Employee() {
    }
    public Employee(Long id) {
        this.id = id;
    }

    public Employee(String name, String address, String tel, String email, String job, String department, String role) {
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.job = job;
        this.department = department;
        this.role = role;
    }
}
