package com.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.erp.mapper.AccountMapper;
import com.erp.mapper.CompanyMapper;
import com.erp.pojo.Account;
import com.erp.pojo.Company;
import com.erp.vo.CompanyMo;
import com.erp.vo.SupllierOfferMo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author : DongChenchen
 * @date : 2019/9/7 16:12
 */
@Service
public class CompanyService {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 根据公司id获取公司信息 包括公司关联的账户信息
     * @param id
     * @return
     */
    public CompanyMo findByCompanyId(Long id){
        Company company = companyMapper.selectByPrimaryKey(new Company(id));
        CompanyMo companyMo = JSONObject.parseObject(JSONObject.toJSONString(company), CompanyMo.class);
        Example emp=new Example(Account.class);
        emp.createCriteria().andEqualTo("companyId",id);
        List<Account> accounts = accountMapper.selectByExample(emp);
        companyMo.setAccountList(accounts);
        return companyMo;
    }

}
