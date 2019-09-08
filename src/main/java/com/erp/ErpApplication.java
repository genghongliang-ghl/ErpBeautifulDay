package com.erp;

import com.alibaba.fastjson.JSONObject;
import com.erp.pojo.Logistics;
import com.erp.service.LogisticsService;
import com.erp.utils.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author : Du
 * @date : 2019/8/23 10:12
 * @description :
 */
@SpringBootApplication
@MapperScan("com.erp.mapper")
@EntityScan(basePackages="com.erp.pojo")
public class ErpApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ErpApplication.class);
        ApplicationContext context = springApplication.run(args);
        SpringContextHolder.setApplicationContext(context);
//        EmployeeService emp = context.getBean(EmployeeService.class);
//        Employee e=new Employee("cc","shanghai","1231","dcc668@163.com","kaifa","kaifa","admin");
//        emp.insert(e);
//        LogisticsService emp = context.getBean(LogisticsService.class);
//        Logistics one = emp.findOneCacheById(1L);
//        System.out.println(JSONObject.toJSONString(one));
    }
}
