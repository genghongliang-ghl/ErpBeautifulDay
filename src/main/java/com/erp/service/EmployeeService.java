package com.erp.service;

import com.erp.mapper.EmployeeMapper;
import com.erp.mapper.UserMapper;
import com.erp.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : DongChenchen
 * @date : 2019/9/6 0:22
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    public Integer insert(Employee t){
        return employeeMapper.insert(t);
    }

}
