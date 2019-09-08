package com.erp.service;

import com.erp.mapper.AccountMapper;
import com.erp.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author : DongChenchen
 * @date : 2019/9/6 0:22
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 根据公司id获取多个账号
     * @param companyId
     * @return
     */
    public List<Account> findByCompanyId(Long companyId){
        Example emp=new Example(Account.class);
        emp.createCriteria().andEqualTo("companyId",companyId);
        return accountMapper.selectByExample(emp);
    }

}
