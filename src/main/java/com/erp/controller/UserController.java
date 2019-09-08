package com.erp.controller;

import com.erp.constant.ErpConstant;
import com.erp.pojo.User;
import com.erp.vo.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 获取当前登录用户的用户名
     *
     * @return
     */
    @RequestMapping("/getUsername.do")
    public Result/* ResponseEntity<String>*/ getUsername(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(ErpConstant.USER_IN_SESSION);
        System.out.print(user.getUsername());
        return new Result(200,"ok",user.getUsername());/*ResponseEntity.ok(user.getUsername());*/
    }
}
