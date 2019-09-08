package com.erp.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @version V1.0
 * @author: HR
 * @date: 2019/8/23 14:38
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User {
    @Id
    private Integer id;

    private String username;

    private String password;

}
