package com.erp.vo;

import com.erp.pojo.*;
import lombok.Data;

import java.util.List;

/**
 * @author : DongChenchen
 * @date : 2019/9/7  16:16
 */
@Data
public class CompanyMo extends Company {
    private List<Account> accountList;
}
