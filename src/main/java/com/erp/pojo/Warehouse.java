package com.erp.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;

/**
 * @version V1.0
 * @author: LYH
 * @date: 2019/8/31 22:05
 * @description:
 */
@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_warehouse")
public class Warehouse {

    private  Integer id;
    private String name;
    private Double price;
    private Integer amount;
    private  String position;
    private Date createTime;


}
